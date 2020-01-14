package com.github.biazverkhi.bot.springdata.impl;

import com.github.biazverkhi.bot.model.City;
import com.github.biazverkhi.bot.springdata.CityDAO;
import com.github.biazverkhi.bot.springdata.config.DAOConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ContextConfiguration(classes = DAOConfig.class)
@Transactional
class DefaultCityDAOTest {
    @Autowired
    CityDAO dao;

    @Test
    void addCity() {
        City city = dao.addCity(new City(null, "Тюмень", "Не был там"));
        City city2 = dao.addCity(new City(null, "Москва", "Там много народу"));
        assertNotNull(city);
        assertNotNull(city2);
    }

    @Test
    void updateCity() {
        City city = dao.getCityByName("Москва");
        city.setDescriptionCity("Там пыльно и нечем дышать");
        dao.updateCity(city);
        city = dao.getCityById(city.getId());
        assertEquals("Там пыльно и нечем дышать", city.getDescriptionCity());
    }

    @Test
    void deleteCity() {
        City city = dao.getCityByName("Москва");
        assertNotNull(city);
        dao.deleteCity(city.getId());
        city = dao.getCityByName("Москва");
        assertNull(city);
    }

    @Test
    void deleteCityAll() {
        assertFalse(dao.getListCity().isEmpty());
        dao.deleteCityAll();
        assertTrue(dao.getListCity().isEmpty());
    }

    @Test
    void getListCity() {
        List<City> cityList = dao.getListCity();
        assertFalse(cityList.isEmpty());
        assertEquals(2, cityList.size());
    }


    @Test
    void getCityByName() {
        assertNotNull(dao.getCityByName("Москва"));
        assertNotNull(dao.getCityByName("Прага"));
        assertNull(dao.getCityByName("Берлин"));
    }

    @Test
    void getCityById() {
        assertNotNull(dao.getCityByName("Москва"));
        assertNotNull(dao.getCityByName("Прага"));
        assertNull(dao.getCityById(33L));
    }


    @Test
    void addListCity() {
        List<City> list = List.of(
                new City(null, "Воронеж", "Не знаю"),
                new City(null, "Венеция", "На воде"));
        assertFalse((dao.addListCity(list)).isEmpty());
        dao.deleteCityAll();
        assertTrue((dao.addListCity(new ArrayList<>())).isEmpty());
    }

    @BeforeEach
    void setUp() {
        dao.addCity(new City(null, "Москва", "Там много народу"));
        dao.addCity(new City(null, "Прага", "Там красиво"));
    }


}