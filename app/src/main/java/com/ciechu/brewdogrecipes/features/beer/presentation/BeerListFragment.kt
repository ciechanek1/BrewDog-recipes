package com.ciechu.brewdogrecipes.features.beer.presentation

import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ciechu.brewdogrecipes.R
import com.ciechu.brewdogrecipes.core.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_beer_list.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class BeerListFragment : BaseFragment<BeerViewModel>(R.layout.fragment_beer_list) {

    override val viewModel: BeerViewModel by viewModel()

    private val beerAdapter: BeerAdapter by inject()
    private val layoutManager: LinearLayoutManager by inject()
    private val dividerItemDecoration: DividerItemDecoration by inject()

    override fun initViews() {
        super.initViews()
        initRecyclerView()
    }

    override fun initObserves() {
        super.initObserves()
        observeBeers()
    }

    override fun onIdleState() {
        super.onIdleState()
        progressBar.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        progressBar.visibility = View.VISIBLE
    }

    private fun observeBeers() {
        viewModel.beers.observe(this) {
            beerAdapter.setBeers(it)
        }
    }

    private fun initRecyclerView() {
        beerListRecyclerView.apply {
            layoutManager = this@BeerListFragment.layoutManager
            addItemDecoration(dividerItemDecoration)
            adapter = beerAdapter
        }
    }
}