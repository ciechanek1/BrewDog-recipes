package com.ciechu.brewdogrecipes.features.beer.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ciechu.brewdogrecipes.R
import com.ciechu.brewdogrecipes.features.beer.presentation.model.BeerDisplayable
import kotlinx.android.synthetic.main.item_beer_view.view.*

class BeerAdapter : RecyclerView.Adapter<BeerAdapter.BeerListViewHolder>() {

    private val beers = mutableListOf<BeerDisplayable>()


    fun setBeers(beers: List<BeerDisplayable>) {
        if (beers.isNotEmpty()) this.beers.clear()

        this.beers.addAll(beers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_beer_view, parent, false)
        return BeerListViewHolder(view)
    }

    override fun getItemCount(): Int = beers.size


    override fun onBindViewHolder(holder: BeerListViewHolder, position: Int) {
        holder.bind(beers[position])
    }

    class BeerListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun bind(beerDisplayable: BeerDisplayable) {
            with(itemView) {
                name_beer_cardView.text = beerDisplayable.name
                tagline_cardview.text = beerDisplayable.tagline
                first_brewed_cardView.text = "first brewed: ${beerDisplayable.firstBrewed}"
                abv_cardView.text = "abv: ${beerDisplayable.abv}% "
                ibu_cardView.text = "ibu: ${beerDisplayable.ibu}"
                id_cardView.text = "#${beerDisplayable.id}"

                Glide.with(this)
                    .load(beerDisplayable.imageUrl)
                    .into(image_beer)
            }
        }
    }
}