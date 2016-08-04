package com.epam.taf.businessobject;

public class Message {
    private String recipient;
    private String text;

    public Message(){

    }

    public Message(String recipient, String text) {
        this.recipient = recipient;
        this.text = text;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getText() {
        return text;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setText(String text) {
        this.text = text;
    }
}
