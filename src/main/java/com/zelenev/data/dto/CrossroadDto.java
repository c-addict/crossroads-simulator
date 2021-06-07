package com.zelenev.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrossroadDto {

    public CrossroadDto() {
    }

    private String city;

    public CrossroadDto(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CrossroadDto{" +
                "city='" + city + '\'' +
                '}';
    }
}
