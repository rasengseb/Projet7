package com.librairy.webapp.proxy;

import com.librairy.webapp.model.Librairy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="Librairy", url = "localhost:9000")
public interface LibrairyProxy {

    @GetMapping("/librairy/{id}")
    Librairy getLibrairy(int id);

    @GetMapping("/librairy")
    Iterable<Librairy> getLibrairies();
}
