package com.ciechu.brewdogrecipes.core.di

import com.ciechu.brewdogrecipes.features.beer.di.beerModule
import org.koin.core.module.Module

val koinInjector: List<Module> = listOf(
    networkModule,
    //   databaseModule,
    appModule,
    beerModule
)