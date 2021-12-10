//package com.connecttosubh.security.oauth;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//
////@Configuration
////@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//  //  public static final String RESOURCE_ID = "productservice";
//  public static final String RESOURCE_ID = "couponservice";
////    @Value("${publicKey}")
////    private String publicKey;
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.resourceId(RESOURCE_ID);//.tokenStore(jwtTokenStore());-- for symmetric key
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().permitAll()
//                .and().csrf().disable();
//    }
//
//    //FOR SYMMETRIC KEY
////    @Bean
////    public JwtTokenStore jwtTokenStore()
////    {
////        return new JwtTokenStore(jwtAccessTokenConverter());
////    }
////    @Bean
////    public JwtAccessTokenConverter jwtAccessTokenConverter()
////    {
////        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
////
////
////       // KeyStoreKeyFactory factory = new KeyStoreKeyFactory(new ClassPathResource(keyFile), password.toCharArray());
////        //KeyPair keyPair = factory.getKeyPair(alias);
////       // converter.setVerifierKey(publicKey);
////        converter.setSigningKey("hello");
////        return converter;
////    }
//
//}
