package com.androidtutz.anushka.tmdbclient.service;

import com.androidtutz.anushka.tmdbclient.model.MovieDBResponse;
import com.androidtutz.anushka.tmdbclient.model.One;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 7/9/2018.
 */
public interface MovieDataService {


    @GET("?q=the+wire+characters&format=json")
    Call<One> getPopularMovies();


}
