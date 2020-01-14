package com.github.biazverkhi.bot.model;

public class City {
    private Long id;
    private String nameCity;
    private String descriptionCity;

    public City(Long id, String nameCity, String descriptionCity) {
        this.id = id;
        this.nameCity = nameCity;
        this.descriptionCity = descriptionCity;
    }

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getDescriptionCity() {
        return descriptionCity;
    }

    public void setDescriptionCity(String descriptionCity) {
        this.descriptionCity = descriptionCity;
    }
}
