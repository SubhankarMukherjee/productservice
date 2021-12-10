package com.connecttosubh.web.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtRequestModel {

    private String username;
    private String password;
    private String grant_type;
    private String scope;
}
