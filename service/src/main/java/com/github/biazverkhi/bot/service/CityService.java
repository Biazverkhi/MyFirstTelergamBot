package com.github.biazverkhi.bot.service;

import com.github.biazverkhi.bot.model.City;

import java.util.List;

public interface CityService {
    City addCity(City city);

    City updateCity(City city);

    void deleteCity(Long id);

    void deleteCityAll();

    List<City> addListCity(List<City> list);

    List<City> getListCity();

    City getCityByName(String nameCity);

    City getCityById(Long id);


}
