package com.librairy.webapp.proxy;

import com.librairy.webapp.model.Book;
import com.librairy.webapp.model.Copy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Optional;

@FeignClient(name="Copy", url = "localhost:9000")
public interface CopyProxy {

    @GetMapping("/copy")
    List<Copy> getCopyByBook(@RequestHeader(value = "Authorization", required = true) String authorizationHeader, @RequestBody Book book);
}
