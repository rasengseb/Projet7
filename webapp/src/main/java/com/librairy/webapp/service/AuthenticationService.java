package com.librairy.webapp.service;

import com.librairy.webapp.model.JwtRequest;
import com.librairy.webapp.model.JwtResponse;
import com.librairy.webapp.proxy.AuthenticationProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationProxy authenticationProxy;

    public String authenticate(JwtRequest authenticationRequest){
        return authenticationProxy.createAuthenticationToken(authenticationRequest);
    }
}
