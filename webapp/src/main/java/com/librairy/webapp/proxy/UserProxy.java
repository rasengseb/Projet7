package com.librairy.webapp.proxy;

import com.librairy.webapp.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@FeignClient(name="User", url = "localhost:9000")
public interface UserProxy {

    @GetMapping(value = "/user")
    Optional<User> getUser(int id);

//    @PostMapping(value = "/user")
//    void createUser(@RequestBody("user") User user);

}
