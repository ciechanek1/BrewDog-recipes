package com.ciechu.brewdogrecipes.features.beer.di

import com.ciechu.brewdogrecipes.features.beer.all.presentation.BeerAdapter
import com.ciechu.brewdogrecipes.features.beer.all.presentation.BeerListFragment
import com.ciechu.brewdogrecipes.features.beer.all.presentation.BeerViewModel
import com.ciechu.brewdogrecipes.features.beer.data.repository.BeerRepositoryImpl
import com.ciechu.brewdogrecipes.features.beer.details.presentation.BeerDetailsViewModel
import com.ciechu.brewdogrecipes.features.beer.details.presentation.HopAdapter
import com.ciechu.brewdogrecipes.features.beer.details.presentation.MaltAdapter
import com.ciechu.brewdogrecipes.features.beer.details.presentation.MashAdapter
import com.ciechu.brewdogrecipes.features.beer.domain.BeerRepository
import com.ciechu.brewdogrecipes.features.beer.domain.GetBeerUseCase
import com.ciechu.brewdogrecipes.features.beer.navigator.BeerNavigator
import com.ciechu.brewdogrecipes.features.beer.navigator.BeerNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val beerModule = module {
    //data
    factory<BeerRepository> { BeerRepositoryImpl(get(), get(), get()) }

    //domain
    factory { GetBeerUseCase(get()) }

    //presentation
    factory<BeerNavigator> { BeerNavigatorImpl(get()) }

    viewModel { BeerViewModel(get(), get()) }
    viewModel { BeerDetailsViewModel() }
    factory { BeerListFragment() }

    factory { BeerAdapter() }
    factory { HopAdapter() }
    factory { MaltAdapter() }
    factory { MashAdapter() }
}