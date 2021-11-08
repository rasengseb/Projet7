package com.librairy.webapp.proxy;

import com.librairy.webapp.model.JwtRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="Authenticate", url = "localhost:9000")
public interface AuthenticationProxy {

    @PostMapping("/authenticate")
    String createAuthenticationToken(@RequestBody JwtRequest authenticationRequest);
}
