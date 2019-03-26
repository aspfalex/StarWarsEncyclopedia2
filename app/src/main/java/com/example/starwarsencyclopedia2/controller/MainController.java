package com.example.starwarsencyclopedia2.controller;

import android.util.Log;

import com.example.starwarsencyclopedia2.model.People;
import com.example.starwarsencyclopedia2.model.RestStarWarsResponse;
import com.example.starwarsencyclopedia2.view.SecondActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainController {

    private SecondActivity activity;

    public MainController(SecondActivity SecActivity) {
        this.activity = SecActivity;
    }

    public void onStart(){

        //Pour ceux qui veulent aller plus loin
        //Singleton
        //Pour ceux qui veulent aller encore plus loin
        // Injection de dépendances

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestSWAPI restSWAPI = retrofit.create(RestSWAPI.class);

        Call<RestStarWarsResponse> call = restSWAPI.getListPeople();
        call.enqueue(new Callback<RestStarWarsResponse>() {
            @Override
            public void onResponse(Call<RestStarWarsResponse> call,
                                   Response<RestStarWarsResponse> response) {
                RestStarWarsResponse restSWAPI = response.body();

                List<People> listPeople = restSWAPI.getResults();
                activity.showList(listPeople);
            }

            @Override
            public void onFailure(Call<RestStarWarsResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });
    }

}
