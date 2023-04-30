package org.example;

import java.util.Objects;

public class Restaurant {
    private String id;
    private String name;
    private String address;
    private Boolean open_now;
    private String phone_number;
    private int price_level;
    private float rating;

    public Restaurant(String id, String name, String address, Boolean open_now, String phone_number, int price_level, float rating) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.open_now = open_now;
        this.phone_number = phone_number;
        this.price_level = price_level;
        this.rating = rating;
    }

    public Restaurant(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getOpen_now() {
        return open_now;
    }

    public void setOpen_now(Boolean open_now) {
        this.open_now = open_now;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getPrice_level() {
        return price_level;
    }

    public void setPrice_level(int price_level) {
        this.price_level = price_level;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant that = (Restaurant) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
