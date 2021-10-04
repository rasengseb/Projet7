package com.librairy.webapp.proxy;

import com.librairy.webapp.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Optional;


@FeignClient(name="User", url = "localhost:9000")
public interface UserProxy {

    @GetMapping("/user")
    Optional<User> getUser(@RequestHeader(value = "Authorization", required = true) String authorizationHeader,int id);

    @PostMapping("/user")
    User createUser(User user);

}
