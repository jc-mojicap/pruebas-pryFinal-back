package edu.uniandes.pruebasautomatizadas.servicios.util;

import javax.mail.MessagingException;

public class EmailSendResult {
    private boolean sended = false;
    private MessagingException exception;

    public MessagingException getException() {
        return exception;
    }

    public void setException(MessagingException exception) {
        this.exception = exception;
    }

    public boolean isSended() {
        return sended;
    }

    public void setSended(boolean sended) {
        this.sended = sended;
    }
}
