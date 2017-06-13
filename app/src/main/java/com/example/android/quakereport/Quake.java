package com.example.android.quakereport;

/**
 * Created by Larry Osakwe on 6/13/2017.
 */

public class Quake {
    private String magnitude;
    private String location;
    private String date;


    public Quake(String magnitude, String location, String date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
}
