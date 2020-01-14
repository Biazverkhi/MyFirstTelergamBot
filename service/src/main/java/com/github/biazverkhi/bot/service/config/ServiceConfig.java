package com.github.biazverkhi.bot.service.config;

import com.github.biazverkhi.bot.service.CityService;
import com.github.biazverkhi.bot.service.impl.DefaultCityService;
import com.github.biazverkhi.bot.springdata.config.DAOConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    private DAOConfig daoConfig;

    public ServiceConfig(DAOConfig daoConfig) {
        this.daoConfig = daoConfig;
    }

    @Bean
    public CityService getCityService() {
        return new DefaultCityService(daoConfig.getDefaultCityDAO());


    }
}