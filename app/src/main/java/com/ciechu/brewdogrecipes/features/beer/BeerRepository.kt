package com.ciechu.brewdogrecipes.features.beer

import com.ciechu.brewdogrecipes.features.beer.domain.model.Beer

interface BeerRepository {
    suspend fun getBeers(): List<Beer>
}