package org.example.place;

public class ResultsPlace {
    private CurrentOpeningHours current_opening_hours;
    private String formatted_address;
    private String formatted_phone_number;
    private String name;
    private String place_id;
    private int price_level;
    private float rating;

    public CurrentOpeningHours getCurrent_opening_hours() {
        return current_opening_hours;
    }

    public void setCurrent_opening_hours(CurrentOpeningHours current_opening_hours) {
        this.current_opening_hours = current_opening_hours;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getFormatted_phone_number() {
        return formatted_phone_number;
    }

    public void setFormatted_phone_number(String formatted_phone_number) {
        this.formatted_phone_number = formatted_phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
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
}
