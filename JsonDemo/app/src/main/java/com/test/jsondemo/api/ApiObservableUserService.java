package com.test.jsondemo.api;

import com.test.jsondemo.model.UsersResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by filippo on 21/02/2018.
 */

public interface ApiObservableUserService {

    @GET("/users")
    Observable<List<UsersResponse>> getUsers();
}
