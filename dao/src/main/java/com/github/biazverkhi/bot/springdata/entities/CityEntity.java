package com.github.biazverkhi.bot.springdata.entities;

import com.github.biazverkhi.bot.model.City;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "city")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class CityEntity {
    private Long id;
    private String nameCity;
    private String descriptionCity;


    public CityEntity(City city) {
        this.id = city.getId();
        this.nameCity = city.getNameCity();
        this.descriptionCity = city.getDescriptionCity();
    }

    public CityEntity() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", unique = true)
    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    @Column(name = "description")

    public String getDescriptionCity() {
        return descriptionCity;
    }

    public void setDescriptionCity(String descriptionCity) {
        this.descriptionCity = descriptionCity;
    }

    public City convertCityByCityEntity() {
        return new City(this.id,
                this.nameCity,
                this.descriptionCity);

    }

}

