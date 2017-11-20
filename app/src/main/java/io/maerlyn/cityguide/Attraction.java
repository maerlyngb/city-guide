package io.maerlyn.cityguide;

import java.io.Serializable;

/**
 * Data about a single attraction
 *
 * @author Maerlyn Broadbent
 */

public class Attraction implements Serializable {
    private String name;
    private float rating;
    private int imageResourceId;
    private String description;
    private String phoneNum;
    private String url;
    private double lat;
    private double lng;

    public Attraction(String name, float rating, int imageResourceId,
                      String description, String phoneNum, String url, double lat, double lng) {
        this.name = name;
        this.rating = rating;
        this.imageResourceId = imageResourceId;
        this.description = description;
        this.phoneNum = phoneNum;
        this.url = url;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return this.name;
    }

    public int getImageResourceId() {
        return this.imageResourceId;
    }

    public float getRating() {
        return this.rating;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public String getUrl() {
        return url;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
