package com.github.biazverkhi.bot.springdata;


import com.github.biazverkhi.bot.model.City;

import java.util.List;


public interface CityDAO {
    City addCity(City city);

    List<City> addListCity(List<City> list);

    void updateCity(City city);

    void deleteCity(Long id);

    void deleteCityAll();

    List<City> getListCity();

    City getCityByName(String nameCity);

    City getCityById(Long id);

}
