package com.example.cardview;

public class AppsModel {
    private String name;
    private int numOfDowmloads;
    private int thumbnail;

    public AppsModel(String name, int numOfDowmloads, int thumbnail) {
        this.name = name;
        this.numOfDowmloads = numOfDowmloads;
        this.thumbnail = thumbnail;
    }

    public AppsModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfDowmloads() {
        return numOfDowmloads;
    }

    public void setNumOfDowmloads(int numOfDowmloads) {
        this.numOfDowmloads = numOfDowmloads;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
