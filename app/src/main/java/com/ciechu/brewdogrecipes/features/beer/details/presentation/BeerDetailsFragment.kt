package com.ciechu.brewdogrecipes.features.beer.details.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.observe
import com.ciechu.brewdogrecipes.R
import com.ciechu.brewdogrecipes.core.base.BaseFragment
import com.ciechu.brewdogrecipes.features.beer.all.presentation.model.BeerDisplayable
import kotlinx.android.synthetic.main.fragment_beer_details.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeerDetailsFragment : BaseFragment<BeerDetailsViewModel>(R.layout.fragment_beer_details) {

    override val viewModel: BeerDetailsViewModel by viewModel()
    private val hopAdapter: HopAdapter by inject()
    private val maltAdapter: MaltAdapter by inject()
    private val mashAdapter: MashAdapter by inject()

    companion object {
        const val BEER_DETAILS_KEY = "beerDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    override fun initViews() {
        super.initViews()
        initRecyclerView()
    }

    override fun initObserves() {
        super.initObserves()
        observeBeer()
    }

    private fun observeBeer() {
        viewModel.beer.observe(this) { showBeerDetails(it) }
    }

    @SuppressLint("SetTextI18n")
    private fun showBeerDetails(beer: BeerDisplayable) {
        with(this) {
            name_details.text = beer.name
            description_details.text = beer.description
            og_details.text = "Original Gravity: ${beer.targetOg}"
            fg_details.text = "Final Gravity: ${beer.targetFg}"
            attenuation_details.text = "Attenuation: ${beer.attenuationLevel}%"
            ebc_details.text = "Ebc: ${beer.ebc}"
            ph_details.text = "Ph: ${beer.ph}"
            volume_details.text = "Bath volume: ${beer.volume.value} L"
            boil_volume_details.text = "Boil volume: ${beer.boilVolume.value} L"
            brewers_tips_details.text = beer.brewersTips
            fermentation_details.text =
                "Fermentation temp: ${beer.method.fermentation.temp.value}°C"
            yeast_details.text = beer.ingredients.yeast
            hopAdapter.setHops(beer.ingredients.hops)
            maltAdapter.setMalt(beer.ingredients.malt)
            mashAdapter.setMash(beer.method.mash_temp)
        }
    }

    private fun initRecyclerView() {
        hopRecyclerView.apply {
            setHasFixedSize(true)
            adapter = hopAdapter
        }
        maltRecyclerView.apply {
            setHasFixedSize(true)
            adapter = maltAdapter
        }
        mashRecyclerView.apply {
            setHasFixedSize(true)
            adapter = mashAdapter
        }
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<BeerDisplayable>(BEER_DETAILS_KEY)
            ?.let { viewModel.onBeerPassed(it) }
    }
}