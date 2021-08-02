package com.librairy.webapp.repository;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="Lending", url = "localhost:9000")
public interface LendingProxy {
}
