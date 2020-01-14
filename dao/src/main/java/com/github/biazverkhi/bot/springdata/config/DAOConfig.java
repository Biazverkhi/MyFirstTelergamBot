package com.github.biazverkhi.bot.springdata.config;

import com.github.biazverkhi.bot.springdata.CityDAO;
import com.github.biazverkhi.bot.springdata.impl.DefaultCityDAO;
import com.github.biazverkhi.bot.springdata.repository.CityJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.github.biazverkhi.bot.springdata.repository"})
@EntityScan("com.github.biazverkhi.bot.springdata.entities")
//@PropertySource("classpath:/application.yml")
public class DAOConfig {
    @Autowired
    private CityJpaRepository cityJpaRepository;

    @Bean
    public CityDAO getDefaultCityDAO() {
        return new DefaultCityDAO(cityJpaRepository);

    }


}
