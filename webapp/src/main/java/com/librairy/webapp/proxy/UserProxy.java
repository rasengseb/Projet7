package com.librairy.webapp.proxy;

import com.librairy.webapp.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@FeignClient(name="User", url = "localhost:9000")
public interface UserProxy {

    @GetMapping("/user")
    Optional<User> getUser(int id);

    @PostMapping("/user")
    User createUser(User user);

}
