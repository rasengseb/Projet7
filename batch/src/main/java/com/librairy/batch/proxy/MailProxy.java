package com.librairy.batch.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="mail", url="localhost:9000")
public interface MailProxy {
}
