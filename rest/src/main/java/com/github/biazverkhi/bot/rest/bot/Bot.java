package com.github.biazverkhi.bot.rest.bot;

import com.github.biazverkhi.bot.model.City;
import com.github.biazverkhi.bot.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;

public class Bot extends TelegramLongPollingBot {
    private static final Logger log = LoggerFactory.getLogger(Bot.class);

    private CityService cityService;
    private TelegramBotsApi telegramBotsApi;

    private String botUsername;
    private String botToken;
    private String botMessage;
    private String botErrorInput;

    public Bot(TelegramBotsApi telegramBotsApi, BotProperty botProperty, CityService cityService) {
        this.telegramBotsApi = telegramBotsApi;
        this.botUsername = botProperty.getBotUsername();
        this.botToken = botProperty.getBotToken();
        this.botMessage = botProperty.getBotMessage();
        this.botErrorInput = botProperty.getBotErrorInput();
        this.cityService = cityService;
    }

    @PostConstruct
    public void init() {
        try {
            telegramBotsApi.registerBot(this);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        String text = message.getText();
        if (text.equals("/start")) {
            sendMsg(message, botMessage);
        } else {
            sendMsg(message, getDescriptionOfCityName(text));
        }
    }

    //Output a message in the telegram
    private String getDescriptionOfCityName(String cityName) {
        City city = cityService.getCityByName(cityName);
        return city == null
                ? botErrorInput
                : city.getDescriptionCity();
    }


    private synchronized void sendMsg(Message msg, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(msg.getChatId());
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.info("Exception: ", e.toString());
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }


}
