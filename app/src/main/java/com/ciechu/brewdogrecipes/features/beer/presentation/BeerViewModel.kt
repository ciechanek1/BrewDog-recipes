package com.ciechu.brewdogrecipes.features.beer.presentation

import androidx.lifecycle.*
import com.ciechu.brewdogrecipes.features.beer.domain.GetBeerUseCase
import com.ciechu.brewdogrecipes.features.beer.domain.model.Beer
import com.ciechu.brewdogrecipes.features.beer.presentation.model.BeerDisplayable

class BeerViewModel(private val getBeerUseCase: GetBeerUseCase) : ViewModel() {

    private val _beers by lazy {
        MutableLiveData<List<Beer>>()
            .also { getBeers(it) }
    }

    val beers: LiveData<List<BeerDisplayable>> = _beers.map { beers ->
        beers.map { BeerDisplayable(it) }

    }

    private fun getBeers(beerLiveData: MutableLiveData<List<Beer>>) {
        getBeerUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            result.onSuccess { beers ->
                beerLiveData.value = beers
            }
            result.onFailure { }
        }
    }
}