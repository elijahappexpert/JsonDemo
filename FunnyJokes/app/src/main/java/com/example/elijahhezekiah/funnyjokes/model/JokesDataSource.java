package com.example.elijahhezekiah.funnyjokes.model;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Elijah Hezekiah  on 02/03/2018.
 */

public class JokesDataSource {

    private final apiCall converterApi;
    Joke value;


    public JokesDataSource(apiCall Api) {
        this.converterApi = Api;
    }

    public Call<Jokes> readJson (){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.icndb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiCall ap = retrofit.create(apiCall.class);
        return ap;



    }



}