package com.ciechu.brewdogrecipes.features.beer.domain

import com.ciechu.brewdogrecipes.core.base.UseCase
import com.ciechu.brewdogrecipes.features.beer.BeerRepository
import com.ciechu.brewdogrecipes.features.beer.domain.model.Beer


class GetBeerUseCase(private val beerRepository: BeerRepository) :
    UseCase<List<Beer>, Unit>() {

    override suspend fun action(params: Unit) = beerRepository.getBeers()
}