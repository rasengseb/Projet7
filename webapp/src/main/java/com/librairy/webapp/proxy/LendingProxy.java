package com.librairy.webapp.proxy;

import com.librairy.webapp.model.Lending;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="Lending", url = "localhost:9000")
public interface LendingProxy {

    @GetMapping("/lending/{id}")
    Lending getLending(int id);

    @GetMapping("/lending")
    Iterable<Lending> getLendings();
}
