package com.ciechu.brewdogrecipes.features.beer.details.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ciechu.brewdogrecipes.R
import com.ciechu.brewdogrecipes.features.beer.domain.model.Mash
import kotlinx.android.synthetic.main.item_mash_view.view.*

class MashAdapter : RecyclerView.Adapter<MashAdapter.MashViewHolder>() {

    private val mash = mutableListOf<Mash>()

    fun setMash(mash: List<Mash>) {
        if (mash.isNotEmpty()) this.mash.clear()

        this.mash.addAll(mash)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MashViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mash_view, parent, false)
        return MashViewHolder(view)
    }

    override fun getItemCount(): Int = mash.size

    override fun onBindViewHolder(holder: MashViewHolder, position: Int) {
        holder.bind(mash[position])
    }

    class MashViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun bind(mash: Mash) {
            with(itemView) {
                mash_temp_view.text = "${mash.temp.value}°C "
                mash_duration_view.text = "${mash.duration} minutes"
            }
        }
    }
}