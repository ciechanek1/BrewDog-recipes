package com.ciechu.brewdogrecipes.core.database.converters

import androidx.room.TypeConverter
import com.ciechu.brewdogrecipes.features.beer.domain.model.Ingredients
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class IngredientsConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromBoilVolumeToJson(data: Ingredients): String {
            return Gson().toJson(data)
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonToBoilVolume(json: String): Ingredients {
            return Gson().fromJson(json, object : TypeToken<Ingredients>() {}.type)
        }
    }
}