package com.librairy.webapp.proxy;

import com.librairy.webapp.model.Copy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="Copy", url = "localhost:9000")
public interface CopyProxy {

    @GetMapping("/copy/{id}")
    List<Copy> getCopyByBook(@PathVariable int id);

}
