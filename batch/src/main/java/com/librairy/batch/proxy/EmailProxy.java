package com.librairy.batch.proxy;

public interface EmailProxy {

    void sendSimpleMessage(String to, String subject, String text);
    
}
