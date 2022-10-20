package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class Beer {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("brand")
    private String brand;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Beer(int id, String name, String brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }
}
