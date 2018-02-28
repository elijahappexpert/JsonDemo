package com.test.jsondemo.model;

/**
 * Created by filippo on 22/02/2018.
 */

public class Geo {

    private String lat;
    private String lng;

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
