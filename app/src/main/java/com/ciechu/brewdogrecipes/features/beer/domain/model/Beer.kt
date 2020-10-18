package com.ciechu.brewdogrecipes.features.beer.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Beer(
    val abv: Double,
    val attenuationLevel: Double,
    val boilVolume: BoilVolume,
    val brewersTips: String,
    val contributedBy: String,
    val description: String,
    val ebc: Double,
    val firstBrewed: String,
    val foodPairing: List<String>,
    val ibu: Double,
    val id: Int,
    val imageUrl: String?,
    val ingredients: Ingredients,
    val method: Method,
    val name: String,
    val ph: Double,
    val srm: Double,
    val tagline: String,
    val targetFg: Double,
    val targetOg: Double,
    val volume: Volume
) {
    companion object
}

@Parcelize
data class BoilVolume(
    val unit: String,
    val value: Int
) : Parcelable

@Parcelize
data class Ingredients(
    val hops: List<Hop>,
    val malt: List<Malt>,
    val yeast: String
) : Parcelable

@Parcelize
data class Method(
    val fermentation: Fermentation,
    val mash_temp: List<Mash>,
) : Parcelable

@Parcelize
data class Volume(
    val unit: String,
    val value: Int
) : Parcelable

@Parcelize
data class Malt(
    val amount: Amount,
    val name: String
) : Parcelable

@Parcelize
data class Amount(
    val unit: String,
    val value: Double
) : Parcelable

@Parcelize
data class Fermentation(
    val temp: FermentationTemp
) : Parcelable

@Parcelize
data class Mash(
    val duration: Int,
    val temp: MashTemp
) : Parcelable

@Parcelize
data class FermentationTemp(
    val unit: String,
    val value: Double
) : Parcelable

@Parcelize
data class MashTemp(
    val unit: String,
    val value: Int
) : Parcelable

@Parcelize
data class Hop(
    val name: String,
    val amount: HopAmount,
    val add: String,
    val attribute: String
) : Parcelable

@Parcelize
data class HopAmount(
    val unit: String,
    val value: Double
) : Parcelable