package com.librairy.batch.proxy;

import com.librairy.batch.model.Lending;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="mail", url="localhost:9000")
public interface MailProxy {

    /**
     * Récupère tous les prêts en retard
     * @return List des retards
     */
    @GetMapping("/lendings")
    List<Lending> getAllDelay();
}
