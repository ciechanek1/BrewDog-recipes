package com.ciechu.brewdogrecipes.features.beer.details.presentation

import com.ciechu.brewdogrecipes.R
import com.ciechu.brewdogrecipes.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeerDetailsFragment : BaseFragment<BeerDetailsViewModel>(R.layout.fragment_beer_details) {

    override val viewModel: BeerDetailsViewModel by viewModel()

    companion object {
        const val BEER_DETAILS_KEY = "beerDetailsKey"
    }

}