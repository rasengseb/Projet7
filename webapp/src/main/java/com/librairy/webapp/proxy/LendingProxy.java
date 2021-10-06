package com.librairy.webapp.proxy;

import com.librairy.webapp.model.Lending;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name="Lending", url = "localhost:9000")
public interface LendingProxy {

    @GetMapping("/lending/{id}")
    Lending getLending(int id);

    @GetMapping("/lending")
    Iterable<Lending> getLendings();

    @GetMapping("/lending")
    List<Lending> findLendingByUser(@RequestHeader(value = "Authorization", required = true) String authorizationHeader, int id);

    @PostMapping("/lending")
    void saveLending(@RequestHeader(value = "Authorization", required = true) String authorizationHeader, Lending lending);

}
