package com.ciechu.brewdogrecipes.features.beer.all.presentation

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.ciechu.brewdogrecipes.R
import com.ciechu.brewdogrecipes.core.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_beer_list.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeerListFragment : BaseFragment<BeerViewModel>(R.layout.fragment_beer_list) {

    override val viewModel: BeerViewModel by viewModel()
    private val beerAdapter: BeerAdapter by inject()

    private lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_page, menu)

        val menuItem = menu.findItem(R.id.search_beer_button)
        searchView = menuItem.actionView as SearchView
        searchView.queryHint = "Search beers"

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.currentQuery = newText.toString()
                viewModel.getBeers(
                    viewModel.currentQuery,
                    viewModel.currentPage.toString(),
                    viewModel.pageSize.toString()
                )
                viewModel.currentQuery = ""
                return false
            }
        })
    }

    override fun initViews() {
        super.initViews()
        initRecyclerView()
        titleActionBar()
    }

    private fun titleActionBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "BrewDog beer list"
    }

    override fun initObserves() {
        super.initObserves()
        observeBeers()
        viewModel.getBeers(
            viewModel.currentQuery,
            viewModel.currentPage.toString(),
            viewModel.pageSize.toString()
        )
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
            setHasFixedSize(true)
            adapter = beerAdapter
        }
        beerAdapter.setOnBeerClickListener { viewModel.onBeerClick(it) }
    }
}