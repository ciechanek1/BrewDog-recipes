package com.ciechu.brewdogrecipes.features.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ciechu.brewdogrecipes.features.beer.domain.model.*

@Entity
data class BeerCashed(
    @PrimaryKey
    val id: Int,
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

    constructor(beer: Beer) : this(
        beer.id,
        beer.abv,
        beer.attenuationLevel,
        beer.boilVolume,
        beer.brewersTips,
        beer.contributedBy,
        beer.description,
        beer.ebc,
        beer.firstBrewed,
        beer.foodPairing,
        beer.ibu,
        beer.imageUrl,
        beer.ingredients,
        beer.method,
        beer.name,
        beer.ph,
        beer.srm,
        beer.tagline,
        beer.targetFg,
        beer.targetOg,
        beer.volume
    )

    companion object

    fun toBeer() = Beer(
        abv = abv,
        attenuationLevel = attenuationLevel,
        boilVolume = boilVolume,
        brewersTips = brewersTips,
        contributedBy = contributedBy,
        description = description,
        ebc = ebc,
        firstBrewed = firstBrewed,
        foodPairing = foodPairing,
        ibu = ibu,
        id = id,
        imageUrl = imageUrl,
        ingredients = ingredients,
        method = method,
        name = name,
        ph = ph,
        srm = srm,
        tagline = tagline,
        targetFg = targetFg,
        targetOg = targetOg,
        volume = volume
    )
}

