package com.example.starwarsencyclopedia2;

import com.example.starwarsencyclopedia2.model.RestPokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;




public interface RestPokemonApi {

    @GET("pokemon")
    Call<RestPokemonResponse> getListPokemon();
}
