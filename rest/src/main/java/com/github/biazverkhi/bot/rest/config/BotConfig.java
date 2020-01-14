package com.github.biazverkhi.bot.rest.config;

import com.github.biazverkhi.bot.rest.bot.Bot;
import com.github.biazverkhi.bot.rest.bot.BotProperty;
import com.github.biazverkhi.bot.service.config.ServiceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.telegram.telegrambots.meta.TelegramBotsApi;

@Configuration
@PropertySource("classpath:bot.properties")
public class BotConfig {

    private ServiceConfig serviceConfig;

    public BotConfig(ServiceConfig serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    @Bean
    public TelegramBotsApi getTelegramBotsApi() {
        return new TelegramBotsApi();
    }


    @Bean
    public Bot getBot(TelegramBotsApi telegramBotsApi, BotProperty botProperty) {
        return new Bot(telegramBotsApi, botProperty, serviceConfig.getCityService());
    }

    @Bean
    public BotProperty getBotProperty() {
        return new BotProperty();
    }

}
