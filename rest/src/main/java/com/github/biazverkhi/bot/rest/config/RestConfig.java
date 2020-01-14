package com.github.biazverkhi.bot.rest.config;

import com.github.biazverkhi.bot.rest.controller.CityRestController;
import com.github.biazverkhi.bot.service.config.ServiceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class RestConfig {

    private ServiceConfig serviceConfig;

    public RestConfig(ServiceConfig serviceConfig) {
        this.serviceConfig = serviceConfig;
    }


    @Bean
    public CityRestController getCityRestController() {
        return new CityRestController(serviceConfig.getCityService());
    }


}
