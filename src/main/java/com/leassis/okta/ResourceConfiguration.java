package com.leassis.okta;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableOAuth2Client
//@PropertySource("classpath:reddit.properties")
public class ResourceConfiguration {

//    @Value("${accessTokenUri}")
    private String accessTokenUri;

//    @Value("${userAuthorizationUri}")
    private String userAuthorizationUri;

//    @Value("${clientID}")
    private String clientID;

//    @Value("${clientSecret}")
    private String clientSecret;

//    @Bean
//    public OAuth2ProtectedResourceDetails reddit() {
//        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
//        details.setId("reddit");
//        details.setClientId(clientID);
//        details.setClientSecret(clientSecret);
//        details.setAccessTokenUri(accessTokenUri);
//        details.setUserAuthorizationUri(userAuthorizationUri);
//        details.setTokenName("oauth_token");
//        details.setScope(Arrays.asList("identity"));
//        details.setPreEstablishedRedirectUri("http://localhost/login");
//        details.setUseCurrentUri(false);
//        return details;
//    }
//
//    @Bean
//    public OAuth2RestTemplate redditRestTemplate(OAuth2ClientContext clientContext) {
//        AccessTokenProvider accessTokenProvider = new AccessTokenProviderChain(
//                Arrays.<AccessTokenProvider> asList(
//                        new MyAuthorizationCodeAccessTokenProvider(),
//                        new ImplicitAccessTokenProvider(),
//                        new ResourceOwnerPasswordAccessTokenProvider(),
//                        new ClientCredentialsAccessTokenProvider())
//        );
//
//        OAuth2RestTemplate template = new OAuth2RestTemplate(reddit(), clientContext);
//        template.setAccessTokenProvider(accessTokenProvider);
//        return template;
//    }

}
