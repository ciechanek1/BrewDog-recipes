package com.ciechu.brewdogrecipes.mock

import com.ciechu.brewdogrecipes.features.beer.domain.model.*
import com.ciechu.brewdogrecipes.features.data.local.model.BeerCashed
import com.ciechu.brewdogrecipes.features.data.remote.model.*
import org.jetbrains.annotations.TestOnly

@TestOnly
fun BeerRemote.Companion.mock() = BeerRemote(
    abv = 1.12,
    attenuationLevel = 1.04,
    boilVolume = BoilVolumeRemote("unit", 5),
    brewersTips = "brewerTips",
    contributedBy = "contributedBy",
    description = "description",
    ebc = 10.11,
    firstBrewed = "firstBrewed",
    foodPairing = emptyList(),
    ibu = 1.03,
    id = 2,
    imageUrl = "imageUrl",
    ingredients = IngredientsRemote(emptyList(), emptyList(), "yeas"),
    method = MethodRemote(
        FermentationRemote(FermentationTempRemote("unit", 1.04)),
        emptyList(),
        "any()"
    ),
    name = "name",
    ph = 4.50,
    srm = 1.04,
    tagline = "tagline",
    targetFg = 1.04,
    targetOg = 1.04,
    volume = VolumeRemote("unit", 5)
)

@TestOnly
fun BeerCashed.Companion.mock() = BeerCashed(
    abv = 1.12,
    attenuationLevel = 1.04,
    boilVolume = BoilVolume("unit", 5),
    brewersTips = "brewerTips",
    contributedBy = "contributedBy",
    description = "description",
    ebc = 10.11,
    firstBrewed = "firstBrewed",
    foodPairing = emptyList(),
    ibu = 1.03,
    id = 2,
    imageUrl = "imageUrl",
    ingredients = Ingredients(emptyList(), emptyList(), "yeas"),
    method = Method(Fermentation(FermentationTemp("unit", 1.04)), emptyList(), "any()"),
    name = "name",
    ph = 4.50,
    srm = 1.04,
    tagline = "tagline",
    targetFg = 1.04,
    targetOg = 1.04,
    volume = Volume("unit", 5)
)

@TestOnly
fun Beer.Companion.mock() = Beer(
    abv = 1.12,
    attenuationLevel = 1.04,
    boilVolume = BoilVolume("unit", 5),
    brewersTips = "brewerTips",
    contributedBy = "contributedBy",
    description = "description",
    ebc = 10.11,
    firstBrewed = "firstBrewed",
    foodPairing = emptyList(),
    ibu = 1.03,
    id = 2,
    imageUrl = "imageUrl",
    ingredients = Ingredients(emptyList(), emptyList(), "yeas"),
    method = Method(Fermentation(FermentationTemp("unit", 1.04)), emptyList(), "any()"),
    name = "name",
    ph = 4.50,
    srm = 1.04,
    tagline = "tagline",
    targetFg = 1.04,
    targetOg = 1.04,
    volume = Volume("unit", 5)
)