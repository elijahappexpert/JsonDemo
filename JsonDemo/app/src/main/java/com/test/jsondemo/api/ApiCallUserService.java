package com.test.jsondemo.api;

import com.test.jsondemo.model.UsersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by filippo on 21/02/2018.
 */

public interface ApiCallUserService {

    @GET("/users")
    Call<List<UsersResponse>> getUsers();
}
