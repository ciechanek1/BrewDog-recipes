package com.ciechu.brewdogrecipes.features.beer.all.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ciechu.brewdogrecipes.R
import com.ciechu.brewdogrecipes.features.beer.all.presentation.model.BeerDisplayable
import kotlinx.android.synthetic.main.item_beer_view.view.*

class BeerAdapter : RecyclerView.Adapter<BeerAdapter.BeerListViewHolder>() {

    private val beers = mutableListOf<BeerDisplayable>()
    private var listener: ((BeerDisplayable) -> Unit)? = null

    fun setBeers(beers: List<BeerDisplayable>) {
        if (beers.isNotEmpty()) this.beers.clear()

        this.beers.addAll(beers)
        notifyDataSetChanged()
    }

    fun setOnBeerClickListener(listener: (BeerDisplayable) -> Unit) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_beer_view, parent, false)
        return BeerListViewHolder(view)
    }

    override fun getItemCount(): Int = beers.size


    override fun onBindViewHolder(holder: BeerListViewHolder, position: Int) {
        val beer = beers[position]
        holder.bind(beer, listener)
    }

    class BeerListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun bind(
            beerDisplayable: BeerDisplayable,
            listener: ((BeerDisplayable) -> Unit)?
        ) {
            with(itemView) {
                name_beer_cardView.text = beerDisplayable.name
                tagline_cardview.text = beerDisplayable.tagline
                first_brewed_cardView.text = "first brewed: ${beerDisplayable.firstBrewed}"
                abv_cardView.text = "abv: ${beerDisplayable.abv}% "
                ibu_cardView.text = "ibu: ${beerDisplayable.ibu}"
                id_cardView.text = "#${beerDisplayable.id}"

                listener?.let { rootView.setOnClickListener { it(beerDisplayable) } }

                Glide.with(this)
                    .load(beerDisplayable.imageUrl)
                    .into(image_beer)
            }
        }
    }
}