package com.ciechu.brewdogrecipes.features.beer.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ciechu.brewdogrecipes.core.base.BaseViewModel
import com.ciechu.brewdogrecipes.features.beer.all.presentation.model.BeerDisplayable

class BeerDetailsViewModel : BaseViewModel() {

    private val _beer by lazy { MutableLiveData<BeerDisplayable>() }
    val beer: LiveData<BeerDisplayable> by lazy { _beer }

    fun onBeerPassed(beer: BeerDisplayable) {
        _beer.value = beer
    }


}