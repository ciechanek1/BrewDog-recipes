package com.ciechu.brewdogrecipes.features.beer.details.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ciechu.brewdogrecipes.R
import com.ciechu.brewdogrecipes.features.beer.domain.model.Hop
import kotlinx.android.synthetic.main.item_hop_view.view.*

class HopAdapter : RecyclerView.Adapter<HopAdapter.HopViewHolder>() {

    private val hop = mutableListOf<Hop>()

    fun setHops(hop: List<Hop>) {
        if (hop.isNotEmpty()) this.hop.clear()

        this.hop.addAll(hop)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HopViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hop_view, parent, false)
        return HopViewHolder(view)
    }

    override fun getItemCount(): Int = hop.size

    override fun onBindViewHolder(holder: HopViewHolder, position: Int) {
        holder.bind(hop[position])
    }

    class HopViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun bind(hop: Hop) {
            with(itemView) {
                hop_name_view.text = hop.name
                hop_value_view.text = "  ${hop.amount.value} g"
                add_hop_view.text = "Add: ${hop.add}"
                attribute_hop_view.text = hop.attribute
            }
        }
    }
}