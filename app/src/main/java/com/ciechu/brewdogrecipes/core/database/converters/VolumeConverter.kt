package com.ciechu.brewdogrecipes.core.database.converters

import androidx.room.TypeConverter
import com.ciechu.brewdogrecipes.features.beer.domain.model.Volume
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class VolumeConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromBoilVolumeToJson(data: Volume): String {
            return Gson().toJson(data)
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonToBoilVolume(json: String): Volume {
            return Gson().fromJson(json, object : TypeToken<Volume>() {}.type)
        }
    }
}