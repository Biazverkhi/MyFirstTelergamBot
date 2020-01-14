package com.github.biazverkhi.bot.rest.controller;

import com.github.biazverkhi.bot.model.City;
import com.github.biazverkhi.bot.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityRestController {
    private CityService cityService;

    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<City>> getAllCity() {
        List<City> cityList = cityService.getListCity();
        return cityList.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(cityList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<City> getCityById(@PathVariable("id") Long id) {
        City city = cityService.getCityById(id);
        return city == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        City newCity = cityService.addCity(city);
        return new ResponseEntity<>(newCity, HttpStatus.CREATED);
    }

    @PostMapping(value = "/list")
    public ResponseEntity<List<City>> addListCity(@RequestBody List<City> city) {
        List<City> list = cityService.addListCity(city);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<City> updateCity(
            @PathVariable("id") Long id,
            @RequestBody City newCity) {
        City city = cityService.getCityById(id);
        if (city == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.setNameCity(newCity.getNameCity());
        city.setDescriptionCity(newCity.getDescriptionCity());
        newCity = cityService.updateCity(city);
        return new ResponseEntity<>(newCity, HttpStatus.OK);
    }


    @PatchMapping(value = "/{id}")
    public ResponseEntity<City> updateCityDescription(
            @PathVariable("id") Long id,
            @RequestBody String description) {
        City city = cityService.getCityById(id);
        if (city == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.setDescriptionCity(description);
        city = cityService.updateCity(city);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
        return "OK";
    }

    @DeleteMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCityAll() {
        cityService.deleteCityAll();
        return "OK";
    }

}
