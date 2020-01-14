package com.github.biazverkhi.bot.rest.bot;

import org.springframework.beans.factory.annotation.Value;

public class BotProperty {
    @Value("${botUsername}")
    String botUsername;
    @Value("${botToken}")
    String botToken;
    @Value("${botMessage}")
    String botMessage;
    @Value("${botErrorInput}")
    private String botErrorInput;


    public BotProperty() {
    }

    public String getBotUsername() {
        return botUsername;
    }

    public void setBotUsername(String botUsername) {
        this.botUsername = botUsername;
    }

    public String getBotToken() {
        return botToken;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public String getBotMessage() {
        return botMessage;
    }

    public void setBotMessage(String botMessage) {
        this.botMessage = botMessage;
    }

    public String getBotErrorInput() {
        return botErrorInput;
    }

    public void setBotErrorInput(String botErrorInput) {
        this.botErrorInput = botErrorInput;
    }
}
