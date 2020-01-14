package com.github.biazverkhi.bot;

import com.github.biazverkhi.bot.rest.config.BotConfig;
import com.github.biazverkhi.bot.rest.config.RestConfig;
import com.github.biazverkhi.bot.service.config.ServiceConfig;
import com.github.biazverkhi.bot.springdata.config.DAOConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import({DAOConfig.class, ServiceConfig.class, BotConfig.class, RestConfig.class})

public class AppRunner extends SpringBootServletInitializer {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(AppRunner.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AppRunner.class);
    }
}
