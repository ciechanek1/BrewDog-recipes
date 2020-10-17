package com.ciechu.brewdogrecipes.features.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ciechu.brewdogrecipes.features.data.local.model.BeerCashed

@Dao
interface BeerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBeers(vararg beer: BeerCashed)

    @Query("SELECT * FROM BeerCashed")
    suspend fun getBeers(): List<BeerCashed>
}
