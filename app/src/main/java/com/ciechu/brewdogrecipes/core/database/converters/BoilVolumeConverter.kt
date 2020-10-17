package com.ciechu.brewdogrecipes.core.database.converters

import androidx.room.TypeConverter
import com.ciechu.brewdogrecipes.features.beer.domain.model.BoilVolume
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class BoilVolumeConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromBoilVolumeToJson(data: BoilVolume): String {
            return Gson().toJson(data)
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonToBoilVolume(json: String): BoilVolume {
            return Gson().fromJson(json, object : TypeToken<BoilVolume>() {}.type)
        }
    }
}
