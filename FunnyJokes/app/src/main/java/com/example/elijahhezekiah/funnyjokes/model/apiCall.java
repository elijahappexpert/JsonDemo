package com.example.elijahhezekiah.funnyjokes.model;


import retrofit2.Call;
import retrofit2.http.GET;


public interface apiCall extends Call<Jokes> {
    @GET("/jokes/jokenumber")
    Call<Jokes> getJokes();


    @GET ("/jokes/random")
    Call<Jokes> getRandomJokes();
}
