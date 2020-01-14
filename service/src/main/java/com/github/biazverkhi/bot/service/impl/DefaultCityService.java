package com.github.biazverkhi.bot.service.impl;

import com.github.biazverkhi.bot.model.City;
import com.github.biazverkhi.bot.service.CityService;
import com.github.biazverkhi.bot.springdata.CityDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DefaultCityService implements CityService {


    private CityDAO cityDAO;

    public DefaultCityService(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    @Override
    public City addCity(City city) {
        return cityDAO.addCity(city);
    }

    @Override
    public City updateCity(City city) {
        cityDAO.updateCity(city);
        return cityDAO.getCityById(city.getId());
    }

    @Override
    public void deleteCity(Long id) {
        cityDAO.deleteCity(id);
    }

    @Override
    public void deleteCityAll() {
        cityDAO.deleteCityAll();
    }

    @Override
    public List<City> addListCity(List<City> list) {
        return cityDAO.addListCity(list);
    }

    @Override
    public List<City> getListCity() {
        return cityDAO.getListCity();
    }

    @Override
    public City getCityByName(String nameCity) {
        return cityDAO.getCityByName(nameCity);
    }

    @Override
    public City getCityById(Long id) {
        return cityDAO.getCityById(id);
    }
}
