package com.test.jsondemo.model;

import com.test.jsondemo.api.apiCall;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Elijah Hezekiah  on 22/02/2018.
 */

public class JokesDataSource {

    public static final String JOKES_BASE_URL = "http://api.icndb.com";

    private MyCallback listener;

    public void readGson(String URL, MyCallback retrievedListener){
        this.listener = retrievedListener;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiCall ap = retrofit.create(apiCall.class);

        Call<Jokes> jokers = ap.getJokes();

        jokers.enqueue(new Callback<Jokes>() {
            @Override
            public void onResponse(Call<Jokes> call, Response<Jokes> response) {
                if (response.isSuccessful()) {
                    Jokes body = response.body();
                    listener.onDataRetrieved( body.getValue());
                }
            }

            @Override
            public void onFailure(Call<Jokes> call, Throwable t) {

            }
        });
    }

    public interface MyCallback {

        void onDataRetrieved(ArrayList<Joke> Value);
    }
}
