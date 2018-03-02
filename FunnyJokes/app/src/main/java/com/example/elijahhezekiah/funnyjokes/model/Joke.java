package com.example.elijahhezekiah.funnyjokes.model;

/**
 * Created by Elijah on 22/02/2018.
 */


        import android.databinding.ObservableField;

        import java.io.Serializable;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Joke extends ObservableField<Jokes> implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("joke")
    @Expose
    private String joke;
    private final static long serialVersionUID = -6639608706633687427L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

}

