package com.ciechu.brewdogrecipes.features.data.remote.model

import com.ciechu.brewdogrecipes.features.beer.domain.model.*
import com.google.gson.annotations.SerializedName

class BeerResponse(
    val results: List<BeerRemote>
)

data class BeerRemote(
    @SerializedName("abv") val abv: Double,
    @SerializedName("attenuation_level") val attenuationLevel: Double,
    @SerializedName("boil_volume") val boilVolume: BoilVolumeRemote,
    @SerializedName("brewers_tips") val brewersTips: String,
    @SerializedName("contributed_by") val contributedBy: String,
    @SerializedName("description") val description: String,
    @SerializedName("ebc") val ebc: Double,
    @SerializedName("first_brewed") val firstBrewed: String,
    @SerializedName("food_pairing") val foodPairing: List<String>,
    @SerializedName("ibu") val ibu: Double,
    @SerializedName("id") val id: Int,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("ingredients") val ingredients: IngredientsRemote,
    @SerializedName("method") val method: MethodRemote,
    @SerializedName("name") val name: String,
    @SerializedName("ph") val ph: Double,
    @SerializedName("srm") val srm: Double,
    @SerializedName("tagline") val tagline: String,
    @SerializedName("target_fg") val targetFg: Double,
    @SerializedName("target_og") val targetOg: Double,
    @SerializedName("volume") val volume: VolumeRemote
) {
    fun toBeer() = Beer(
        abv = abv,
        attenuationLevel = attenuationLevel,
        boilVolume = boilVolume.toBoilVolume(),
        brewersTips = brewersTips,
        contributedBy = contributedBy,
        description = description,
        ebc = ebc,
        firstBrewed = firstBrewed,
        foodPairing = foodPairing,
        ibu = ibu,
        id = id,
        imageUrl = imageUrl,
        ingredients = ingredients.toIngredients(),
        method = method.toMethod(),
        name = name,
        ph = ph,
        srm = srm,
        tagline = tagline,
        targetFg = targetFg,
        targetOg = targetOg,
        volume = volume.toVolume()
    )
}

data class BoilVolumeRemote(
    val unit: String,
    val value: Int
) {
    fun toBoilVolume() = BoilVolume(unit, value)
}

data class IngredientsRemote(
    val hops: List<Hop>,
    val malt: List<Malt>,
    val yeast: String
) {
    fun toIngredients() = Ingredients(hops, malt, yeast)
}

data class MethodRemote(
    val fermentation: FermentationRemote,
    val mashTemp: List<Mash>,
    val twist: Any
) {
    fun toMethod() = Method(fermentation.toFermentation(), mashTemp, twist)
}

data class VolumeRemote(
    val unit: String,
    val value: Int
) {
    fun toVolume() = Volume(unit, value)
}

data class MaltRemote(
    val amount: AmountRemote,
    val name: String
) {
    fun toMalt() = Malt(amount.toAmount(), name)
}

data class AmountRemote(
    val unit: String,
    val value: Double
) {
    fun toAmount() = Amount(unit, value)
}

data class FermentationRemote(
    val temp: FermentationTempRemote
) {
    fun toFermentation() = Fermentation(temp.toFermentationTemp())
}

data class MashRemote(
    val duration: Int,
    val temp: MashTempRemote
) {
    fun toMash() = Mash(duration, temp.toMashTemp())
}

data class FermentationTempRemote(
    val unit: String,
    val value: Double
) {
    fun toFermentationTemp() = FermentationTemp(unit, value)
}

data class MashTempRemote(
    val unit: String,
    val value: Int
) {
    fun toMashTemp() = MashTemp(unit, value)
}

data class HopRemote(
    val name: String,
    val amount: HopAmountRemote,
    val add: String,
    val attribute: String
) {
    fun toHop() = Hop(name, amount.toHopAmount(), add, attribute)
}

data class HopAmountRemote(
    val unit: String,
    val value: Double
) {
    fun toHopAmount() = HopAmount(unit, value)
}

