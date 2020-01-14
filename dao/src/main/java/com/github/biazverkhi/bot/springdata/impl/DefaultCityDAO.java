package com.github.biazverkhi.bot.springdata.impl;

import com.github.biazverkhi.bot.model.City;
import com.github.biazverkhi.bot.springdata.CityDAO;
import com.github.biazverkhi.bot.springdata.entities.CityEntity;
import com.github.biazverkhi.bot.springdata.repository.CityJpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DefaultCityDAO implements CityDAO {
    private CityJpaRepository cityJpaRepository;

    public DefaultCityDAO(CityJpaRepository cityJpaRepository) {
        this.cityJpaRepository = cityJpaRepository;
    }

    //save or update
    @Override
    public City addCity(City city) {
        CityEntity cityEntity = cityJpaRepository.getCityEntityByNameCity(city.getNameCity());
        if (cityEntity != null) {
            city.setId(cityEntity.getId());
        }
        return cityJpaRepository.save(new CityEntity(city)).convertCityByCityEntity();
    }

    @Override
    public List<City> addListCity(List<City> list) {
        return list.isEmpty()
                ? new ArrayList<>()
                : cityJpaRepository.saveAll(list.stream().map(CityEntity::new).collect(Collectors.toList()))
                .stream().map(CityEntity::convertCityByCityEntity).collect(Collectors.toList());
    }

    @Override
    public void updateCity(City city) {
        addCity(city);
    }

    @Override
    public void deleteCity(Long id) {
        cityJpaRepository.deleteById(id);
    }

    @Override
    public void deleteCityAll() {
        cityJpaRepository.deleteAll();
    }


    @Override
    public List<City> getListCity() {
        List<CityEntity> cityEntityList = cityJpaRepository.findAll();
        return cityEntityList.stream().map(CityEntity::convertCityByCityEntity).collect(Collectors.toList());
    }

    @Override
    public City getCityByName(String nameCity) {
        CityEntity cityEntity = cityJpaRepository.getCityEntityByNameCity(nameCity);
        return cityEntity == null ? null : cityEntity.convertCityByCityEntity();
    }

    @Override
    public City getCityById(Long id) {
        Optional<CityEntity> optional = cityJpaRepository.findById(id);
        return optional.map(CityEntity::convertCityByCityEntity).orElse(null);
    }
}
