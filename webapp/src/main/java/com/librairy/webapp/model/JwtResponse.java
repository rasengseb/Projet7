package com.librairy.webapp.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public JwtResponse(){};

}
