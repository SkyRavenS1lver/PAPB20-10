package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("Beer")
    Call<Beer> getRandomBeer();

    @GET("Beer")
    Call<List<Beer>> getBeers(@Query("size") int number);
}
