package com.ciechu.brewdogrecipes.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ciechu.brewdogrecipes.features.data.local.BeerDao
import com.ciechu.brewdogrecipes.features.data.local.model.BeerCashed

@Database(entities = [BeerCashed::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun beerDao(): BeerDao
}