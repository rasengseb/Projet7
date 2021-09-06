package com.librairy.webapp.proxy;

import com.librairy.webapp.model.JwtRequest;
import com.librairy.webapp.model.JwtResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="Authenticate", url = "localhost:9000")
public interface AuthenticationProxy {

    @PostMapping("/authenticate")
    JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest);
}
