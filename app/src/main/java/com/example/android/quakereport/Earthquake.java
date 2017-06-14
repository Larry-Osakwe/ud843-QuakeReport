package com.example.android.quakereport;

/**
 * Created by Larry Osakwe on 6/13/2017.
 */

public class Earthquake {
    private int magnitude;
    private String location;
    private int date;


    public Earthquake(int magnitude, String location, int date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    public int getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public int getDate() {
        return date;
    }
}
