package com.ciechu.brewdogrecipes.features.data.remote

import com.ciechu.brewdogrecipes.features.data.remote.model.BeerRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface PunkApi {

    @GET("beers")
    suspend fun getBeers(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): List<BeerRemote> //BeerResponse

    @GET("beers")
    suspend fun getBeersByName(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int,
        @Query("beer_name") currentQuery: String
    ): List<BeerRemote>
}