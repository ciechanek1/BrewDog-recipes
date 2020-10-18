package com.ciechu.brewdogrecipes.features.beer.navigator

import com.ciechu.brewdogrecipes.features.beer.all.presentation.model.BeerDisplayable

interface BeerNavigator {
    fun openBeerDetails(beer: BeerDisplayable)
    fun goBack()
}