package com.connecttosubh.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenService {

    @Autowired
    JWTHelper helper;

  public String getJWTToken()
  {
      System.out.println("Inside get JWT TOken Method ");
      System.out.println("Calling AUTH Server:--------->");
      JwtResponseModel jwtToken = helper.getJWTToken(JwtRequestModel.builder().grant_type("password")
              .scope("read write").
              password("doug").username("doug@bailey.com").build());
      System.out.println("Calling AUTH Server FINISH:--------->");
      System.out.println("Access Token"+ jwtToken.getAccess_token().toString());
      System.out.println("Refresh Token"+ jwtToken.getRefresh_token().toString());
      System.out.println("Expiry"+ jwtToken.getExpires_in().toString());
      System.out.println("Scope"+ jwtToken.getScope().toString());

      return jwtToken.getAccess_token();
  }
}
