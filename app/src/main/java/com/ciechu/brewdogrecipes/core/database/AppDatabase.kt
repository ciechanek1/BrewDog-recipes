package com.ciechu.brewdogrecipes.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ciechu.brewdogrecipes.core.database.converters.*
import com.ciechu.brewdogrecipes.features.data.local.BeerDao
import com.ciechu.brewdogrecipes.features.data.local.model.BeerCashed

@Database(entities = [BeerCashed::class], version = 1)
@TypeConverters(
    ListConverter::class,
    BoilVolumeConverter::class,
    IngredientsConverter::class,
    MethodConverter::class,
    VolumeConverter::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun beerDao(): BeerDao
}
