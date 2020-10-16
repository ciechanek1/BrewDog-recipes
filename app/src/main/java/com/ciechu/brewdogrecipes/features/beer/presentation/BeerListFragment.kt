package com.ciechu.brewdogrecipes.features.beer.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ciechu.brewdogrecipes.R
import com.ciechu.brewdogrecipes.core.base.UiState
import org.koin.androidx.viewmodel.ext.android.viewModel


class BeerListFragment : Fragment() {

    private val viewModel: BeerViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeBeers()
        observeUiState()
        observeMessage()
    }

    private fun observeMessage() {
        viewModel.message.observe(this, Observer {
            showToast(it)
        })
    }

    private fun showToast(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun observeUiState() {
        viewModel.uiState.observe(this, Observer {
            when (it) {
                UiState.Idle -> onIdleState()
                UiState.Pending -> onPendingState()
            }
        })
    }

    private fun onIdleState() {
        //handle idle state
    }

    private fun onPendingState() {
        //handle pending state
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