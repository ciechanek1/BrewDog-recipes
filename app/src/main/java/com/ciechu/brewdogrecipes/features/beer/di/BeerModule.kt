package com.ciechu.brewdogrecipes.features.beer.di

import com.ciechu.brewdogrecipes.features.beer.BeerRepository
import com.ciechu.brewdogrecipes.features.beer.data.repository.BeerRepositoryImpl
import com.ciechu.brewdogrecipes.features.beer.domain.GetBeerUseCase
import com.ciechu.brewdogrecipes.features.beer.presentation.BeerListFragment
import com.ciechu.brewdogrecipes.features.beer.presentation.BeerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val beerModule = module {
    //data
    factory<BeerRepository> { BeerRepositoryImpl(get(), get(), get()) }

    //domain
    factory { GetBeerUseCase(get()) }

    //presentation
    viewModel { BeerViewModel(get()) }
    factory { BeerListFragment() }
}