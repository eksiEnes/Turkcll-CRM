package com.turkcell.pair6.invoiceservice.core.service.abstracts;

public interface MessageService {
    String getMessage(String key);
    String getMessageWithArgs(String key, Object... args);
}