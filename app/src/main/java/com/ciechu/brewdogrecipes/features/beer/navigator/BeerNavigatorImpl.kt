package com.ciechu.brewdogrecipes.features.beer.navigator

import com.ciechu.brewdogrecipes.R
import com.ciechu.brewdogrecipes.core.navigation.FragmentNavigator
import com.ciechu.brewdogrecipes.features.beer.all.presentation.model.BeerDisplayable
import com.ciechu.brewdogrecipes.features.beer.details.presentation.BeerDetailsFragment

class BeerNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : BeerNavigator {

    override fun openBeerDetails(beer: BeerDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_beerListFragment_to_beerDetailsFragment,
            BeerDetailsFragment.BEER_DETAILS_KEY to beer
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}