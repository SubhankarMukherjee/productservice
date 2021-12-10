package com.connecttosubh.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class JWTHelper {

    @Autowired
    RestTemplate template;
    public static final String AUTHSERVER_URL = "http://localhost:9092/oauth/token";
    public JwtResponseModel getJWTToken(JwtRequestModel requestModel) {


        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED.toString());
        headers.add("Accept", MediaType.APPLICATION_JSON.toString()); //Optional in case server sends back JSON data

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("username", requestModel.getUsername());
        requestBody.add("password", requestModel.getPassword());
        requestBody.add("grant_type", requestModel.getGrant_type());
        requestBody.add("scope", requestModel.getScope());



        HttpEntity formEntity = new HttpEntity<MultiValueMap<String, String>>(requestBody, headers);


        //return template.postForObject(uri,requestModel,JwtResponseModel.class);
        return template.exchange(AUTHSERVER_URL, HttpMethod.POST, formEntity, JwtResponseModel.class).getBody();
    }
}
