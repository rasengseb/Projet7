package com.librairy.batch.controller;

import com.librairy.batch.model.Lending;
import com.librairy.batch.service.EmailService;
import com.librairy.batch.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @Autowired
    private EmailService emailService;

    /**
     * Récupère tous les prêts en retard et envoie un mail de rappel
     */
    @Scheduled(cron = "0 16 * * ?")
    @GetMapping("/lendings")
    public void allLending() {

        List<Lending> retards = mailService.getAllDelay();
        for (int i=0; i<retards.size(); i++){
            String text = "Madame, Monsieur, Veuillez retourner l'examplaire " + retards.get(i).getCopy().getBook().getTitle() + " de "
                    + retards.get(i).getCopy().getBook().getAuthor() + " à la librairy "
                    + retards.get(i).getCopy().getLibrairy().getName() + " car le delai de prêt est dépassé.";
            emailService.sendSimpleMessage(retards.get(i).getUser().getMail(), "Retard sur retour de prêt", text);
        }
    }
}
