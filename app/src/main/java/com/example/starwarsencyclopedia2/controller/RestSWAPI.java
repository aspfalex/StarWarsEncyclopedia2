package com.example.starwarsencyclopedia2.controller;

import com.example.starwarsencyclopedia2.model.RestStarWarsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestSWAPI {

    @GET("people")
    Call<RestStarWarsResponse> getListPeople();
}
