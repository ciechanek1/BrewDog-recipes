package com.ciechu.brewdogrecipes.features.beer.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ciechu.brewdogrecipes.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class BeerListFragment : Fragment() {

    private val viewModel: BeerViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeBeers()
    }

    private fun observeBeers() {
        viewModel.beers.observe(this, Observer {
            //code to show beers
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_beer_list, container, false)
    }
}