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

    var currentPage = 1
    var pageSize = 50
    var currentQuery = ""

    private val _beers by lazy {
        MutableLiveData<List<Beer>>()
    }

    val beers: LiveData<List<BeerDisplayable>> by lazy {
        _beers.map { beers ->
            beers.map { BeerDisplayable(it) }
        }
    }

    fun getBeers(currentQuery: String, currentPage: Int, pageSize: Int) {
        setPendingState()
        getBeerUseCase(
            params = currentQuery,
            params2 = currentPage,
            params3 = pageSize,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { _beers.value = it }
            result.onFailure { handleFailure(it) }
        }
    }
}