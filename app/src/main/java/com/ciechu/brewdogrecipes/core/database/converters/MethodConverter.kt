package com.ciechu.brewdogrecipes.core.database.converters

import androidx.room.TypeConverter
import com.ciechu.brewdogrecipes.features.beer.domain.model.Method
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MethodConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromBoilVolumeToJson(data: Method): String {
            return Gson().toJson(data)
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonToBoilVolume(json: String): Method {
            return Gson().fromJson(json, object : TypeToken<Method>() {}.type)
        }
    }
}