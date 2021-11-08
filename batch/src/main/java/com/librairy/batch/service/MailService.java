package com.librairy.batch.service;

import com.librairy.batch.proxy.MailProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private MailProxy mailProxy;

}
