package com.ciechu.brewdogrecipes.features.beer.details.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ciechu.brewdogrecipes.R
import com.ciechu.brewdogrecipes.features.beer.domain.model.Malt
import kotlinx.android.synthetic.main.item_malt_view.view.*

class MaltAdapter : RecyclerView.Adapter<MaltAdapter.MaltViewHolder>() {

    private val malt = mutableListOf<Malt>()

    fun setMalt(malt: List<Malt>) {
        if (malt.isNotEmpty()) this.malt.clear()

        this.malt.addAll(malt)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaltViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_malt_view, parent, false)
        return MaltViewHolder(view)
    }

    override fun getItemCount(): Int = malt.size

    override fun onBindViewHolder(holder: MaltViewHolder, position: Int) {
        holder.bind(malt[position])
    }

    class MaltViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun bind(malt: Malt) {
            with(itemView) {
                malt_name_view_details.text = malt.name
                malt_amount_view_details.text = "${malt.amount.value} kg"
            }
        }
    }
}