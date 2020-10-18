package com.ciechu.brewdogrecipes.features.beer.domain

import com.ciechu.brewdogrecipes.features.beer.domain.model.Beer

interface BeerRepository {

    suspend fun getBeers(currentQuery: String?, currentPage: String, pageSize: String): List<Beer>
}