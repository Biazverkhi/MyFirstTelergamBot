package com.github.biazverkhi.bot.service.impl;

import com.github.biazverkhi.bot.model.City;
import com.github.biazverkhi.bot.springdata.CityDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DefaultCityServiceTest {
    City city;
    @Mock
    CityDAO dao;
    @InjectMocks
    DefaultCityService defaultCityService;

    @Test
    void addCity() {
        when(dao.addCity(city)).thenReturn(city);
        city = defaultCityService.addCity(city);
        assertNotNull(city);
        assertEquals(city.getNameCity(), "Москва");
    }

    @Test
    void updateCity() {
        when(dao.getCityById(city.getId())).thenReturn(city);
        city = defaultCityService.updateCity(city);
        verify(dao, times(1)).updateCity(city);
        assertNotNull(city);
    }

    @Test
    void deleteCity() {
        defaultCityService.deleteCity(1l);
        verify(dao, times(1)).deleteCity(1l);
    }

    @Test
    void deleteCityAll() {
        defaultCityService.deleteCityAll();
        verify(dao, times(1)).deleteCityAll();
    }

    @Test
    void getListCity() {
        when(dao.getListCity()).thenReturn(new ArrayList<City>());
        assertNotNull(defaultCityService.getListCity());
    }

    @Test
    void getCityByName() {
        when(defaultCityService.getCityByName(city.getNameCity())).thenReturn(city);
        assertNotNull(defaultCityService.getCityByName(city.getNameCity()));
    }

    @Test
    void getCityById() {
        when(defaultCityService.getCityById(city.getId())).thenReturn(city);
        assertNotNull(defaultCityService.getCityById(city.getId()));

    }

    @Test
    void testAddCity() {

        when(defaultCityService.addListCity(new ArrayList<>())).thenReturn(new ArrayList<>());
        assertNotNull(defaultCityService.addListCity(new ArrayList<>()));
    }

    @BeforeEach
    void setUp() {
        city = new City(1l, "Москва", "Там много народу");
    }

}