package com.test.jsondemo.api;



import com.test.jsondemo.model.Jokes;

import retrofit2.Call;
import retrofit2.http.GET;



public interface apiCall {

    @GET("/jokes/jokenumber")
    Call <Jokes> getJokes();
}
