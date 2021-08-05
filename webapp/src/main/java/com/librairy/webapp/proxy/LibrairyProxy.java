package com.librairy.webapp.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="Librairy", url = "localhost:9000")
public interface LibrairyProxy {
}
