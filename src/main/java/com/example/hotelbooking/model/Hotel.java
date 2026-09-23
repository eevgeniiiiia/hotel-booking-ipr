package com.example.hotelbooking.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Hotel {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String city;

    @NotBlank
    private String room;

    @Positive
    private double pricePerNight;

    public Hotel() {
    }

    public Hotel(Long id, String name, String city, String room, double pricePerNight) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.room = room;
        this.pricePerNight = pricePerNight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}

// THIS IS AN INTENTIONAL CHECKSTYLE ERROR FOR CI/CD PIPELINE VERIFICATION TO ENSURE THAT THE QUALITY GATE BLOCKS THE PIPELINE WHEN CODE QUALITY STANDARDS ARE VIOLATED