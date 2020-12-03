package com.startspring.workspace.controllerAndClass;

import java.time.OffsetDateTime;

public class ChatMessage {

    private OffsetDateTime date;
    private String author;
    private String text;

    public ChatMessage() {

    }

    public ChatMessage(OffsetDateTime date, String author, String text) {
        this.date = date;
        this.author = author;
        this.text = text;
    }

    @Override
    public String toString() {
        return "ChatMessage:" +
                "date = " + date +
                ", author = " + author +
                ", text = " + text + "\n";
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }


}
