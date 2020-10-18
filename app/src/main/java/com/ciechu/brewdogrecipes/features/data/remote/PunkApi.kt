package com.ciechu.brewdogrecipes.features.data.remote

import com.ciechu.brewdogrecipes.features.data.remote.model.BeerRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface PunkApi {

    @GET("beers")
    suspend fun getBeers(
        @Query("page") page: String,
        @Query("per_page") per_page: String
    ): List<BeerRemote>

    @GET("beers")
    suspend fun getBeersByName(
        @Query("page") page: String,
        @Query("per_page") per_page: String,
        @Query("beer_name") currentQuery: String
    ): List<BeerRemote>
}