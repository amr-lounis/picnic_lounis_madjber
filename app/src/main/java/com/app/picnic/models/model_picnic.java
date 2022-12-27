package com.app.picnic.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "picnic")
public class model_picnic {
    @PrimaryKey(autoGenerate = true)
    int id;
    String friends;
    String destination;
    int hour ;
    int minute;
    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public model_picnic(String destination,String date, int hour, int minute, String friends) {
        this.destination = destination;
        this.date = date;
        this.hour = hour;
        this.minute = minute;
        this.friends = friends;
    }

    public int getHour() {
        return hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }
}
