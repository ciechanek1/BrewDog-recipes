package com.ciechu.brewdogrecipes.features.beer.presentation.model

import com.ciechu.brewdogrecipes.features.beer.domain.model.*

data class BeerDisplayable(
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
    val imageUrl: String,
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
        abv = beer.abv,
        attenuationLevel = beer.attenuationLevel,
        boilVolume = beer.boilVolume,
        brewersTips = beer.brewersTips,
        contributedBy = beer.contributedBy,
        description = beer.description,
        ebc = beer.ebc,
        firstBrewed = beer.firstBrewed,
        foodPairing = beer.foodPairing,
        ibu = beer.ibu,
        id = beer.id,
        imageUrl = beer.imageUrl,
        ingredients = beer.ingredients,
        method = beer.method,
        name = beer.name,
        ph = beer.ph,
        srm = beer.srm,
        tagline = beer.tagline,
        targetFg = beer.targetFg,
        targetOg = beer.targetOg,
        volume = beer.volume
    )
}
