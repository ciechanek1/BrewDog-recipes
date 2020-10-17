package com.ciechu.brewdogrecipes.features.beer.presentation

import androidx.lifecycle.Observer
import com.ciechu.brewdogrecipes.R
import com.ciechu.brewdogrecipes.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeerListFragment : BaseFragment<BeerViewModel>(R.layout.fragment_beer_list) {

    override val viewModel: BeerViewModel by viewModel()

    override fun initViews() {
        super.initViews()
    }

    override fun initObserves() {
        super.initObserves()
        observeBeers()
    }

    override fun onIdleState() {
        super.onIdleState()
    }

    override fun onPendingState() {
        super.onPendingState()
    }

    private fun observeBeers() {
        viewModel.beers.observe(this, Observer {
            //code to show beers
        })
    }
}