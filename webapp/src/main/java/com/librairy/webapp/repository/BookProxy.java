package com.librairy.webapp.repository;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="Book", url = "localhost:9000")
public interface BookProxy {
}
