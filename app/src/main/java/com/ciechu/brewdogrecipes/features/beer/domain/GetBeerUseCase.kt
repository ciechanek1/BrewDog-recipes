package com.ciechu.brewdogrecipes.features.beer.domain

import com.ciechu.brewdogrecipes.core.base.UseCase
import com.ciechu.brewdogrecipes.features.beer.domain.model.Beer

class GetBeerUseCase(private val beerRepository: BeerRepository) :
    UseCase<List<Beer>, String, String, String>() {

    override suspend fun action(currentQuery: String, startPage: String, pageSize: String) =
        beerRepository.getBeers(currentQuery, startPage, pageSize)
}