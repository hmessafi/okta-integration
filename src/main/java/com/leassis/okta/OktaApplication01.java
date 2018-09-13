package com.leassis.okta;

import com.nimbusds.oauth2.sdk.ParseException;
import com.okta.jwt.JwtHelper;
import com.okta.jwt.JwtVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@EnableOAuth2Sso
@RestController
@SpringBootApplication
public class OktaApplication01 {

    public static void main(String[] args) {
        SpringApplication.run(OktaApplication01.class, args);
    }

    @Autowired(required = false)
    private JwtVerifier jwtVerifier;

    @GetMapping("/")
    public String home(Principal principal, Authentication authentication, HttpServletRequest httpRequest) {
        return principal.getName() + ", app01";
    }

    @GetMapping(value = "/me", produces = "application/json")
    public Principal me(Principal principal) {
        return principal;
    }

    @GetMapping("/is-valid")
    public Boolean isValid(OAuth2Authentication authentication) {
        try {
            String tokenValue = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
            jwtVerifier.decodeAccessToken(tokenValue);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Bean
    JwtVerifier jwtVerifier(@Value("${security.oauth2.issuer}") String issuerUrl,
                            @Value("${security.oauth2.client.client-id}") String clientId)
            throws IOException, ParseException {

        return new JwtHelper()
                .setIssuerUrl(issuerUrl)
                .setClientId(clientId)
                .setConnectionTimeout(1000)
                .setReadTimeout(1000)
                .build();
    }
}
