package com.github.biazverkhi.bot.springdata.repository;

import com.github.biazverkhi.bot.springdata.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CityJpaRepository extends JpaRepository<CityEntity, Long> {
    CityEntity getCityEntityByNameCity(String nameCity);
}
