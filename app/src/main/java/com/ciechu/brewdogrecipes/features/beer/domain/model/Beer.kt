package com.ciechu.brewdogrecipes.features.beer.domain.model

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
)

data class BoilVolume(
    val unit: String,
    val value: Int
)

data class Ingredients(
    val hops: List<Hop>,
    val malt: List<Malt>,
    val yeast: String
)

data class Method(
    val fermentation: Fermentation,
    val mashTemp: List<Mash>,
    val twist: Any
)

data class Volume(
    val unit: String,
    val value: Int
)

data class Malt(
    val amount: Amount,
    val name: String
)

data class Amount(
    val unit: String,
    val value: Double
)

data class Fermentation(
    val temp: FermentationTemp
)

data class Mash(
    val duration: Int,
    val temp: MashTemp
)

data class FermentationTemp(
    val unit: String,
    val value: Double
)

data class MashTemp(
    val unit: String,
    val value: Int
)

data class Hop(
    val name: String,
    val amount: HopAmount,
    val add: String,
    val attribute: String
)

data class HopAmount(
    val unit: String,
    val value: Double
)