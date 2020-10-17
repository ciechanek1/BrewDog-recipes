package com.ciechu.brewdogrecipes.features.beer.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.ciechu.brewdogrecipes.core.base.BaseViewModel
import com.ciechu.brewdogrecipes.features.beer.domain.GetBeerUseCase
import com.ciechu.brewdogrecipes.features.beer.domain.model.Beer
import com.ciechu.brewdogrecipes.features.beer.presentation.model.BeerDisplayable

class BeerViewModel(private val getBeerUseCase: GetBeerUseCase) : BaseViewModel() {

    private val _beers by lazy {
        MutableLiveData<List<Beer>>()
            .also { getBeers(it) }
    }

    val beers: LiveData<List<BeerDisplayable>> by lazy {
        _beers.map { beers ->
            beers.map { BeerDisplayable(it) }
        }
    }

    private fun getBeers(beerLiveData: MutableLiveData<List<Beer>>) {
        setPendingState()
        getBeerUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { beerLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }
}