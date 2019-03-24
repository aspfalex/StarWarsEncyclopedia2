package com.example.starwarsencyclopedia2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.util.Log;

import com.example.starwarsencyclopedia2.model.Pokemon;
import com.example.starwarsencyclopedia2.model.RestPokemonResponse;

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
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestPokemonApi restPokemonApi = retrofit.create(RestPokemonApi.class);

        Call<RestPokemonResponse> call = restPokemonApi.getListPokemon();
        call.enqueue(new Callback<RestPokemonResponse>() {
            @Override
            public void onResponse(Call<RestPokemonResponse> call,
                                   Response<RestPokemonResponse> response) {
                RestPokemonResponse restPokemonResponse = response.body();
                List<Pokemon> listPokemon = restPokemonResponse.getResults();
                activity.showList(listPokemon);
            }

            @Override
            public void onFailure(Call<RestPokemonResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });
    }

}
