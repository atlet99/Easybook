package com.metimol.easybook.api.models;

import com.google.gson.annotations.SerializedName;

public class Genre {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
