package com.ciechu.brewdogrecipes.core.di

import com.ciechu.brewdogrecipes.features.beer.presentation.BeerViewModel
import org.koin.dsl.module

val featuresModule = module {

    factory { BeerViewModel(get()) }
}