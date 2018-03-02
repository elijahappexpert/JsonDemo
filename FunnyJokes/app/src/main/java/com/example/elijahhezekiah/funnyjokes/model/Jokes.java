package com.example.elijahhezekiah.funnyjokes.model;

import java.util.ArrayList;

/**
 * Created by Elijah on 22/02/2018.
 */

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Jokes implements Serializable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("value")
    @Expose
    private Joke value;
    private final static long serialVersionUID = 2833792000498482878L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Joke getValue() {
        return value;
    }

    public void setValue(Joke value) {
        this.value = value;
    }

}
