package com.example.undarkened.Model;

public class Plan {

    String time,ownerid;
    String longitude,latitude;
    String date;

    public Plan(){}

    public Plan(String time, String ownerid, String longitude, String latitude,String date) {
        this.time = time;
        this.ownerid = ownerid;
        this.longitude = longitude;
        this.latitude = latitude;
        this.date=date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
