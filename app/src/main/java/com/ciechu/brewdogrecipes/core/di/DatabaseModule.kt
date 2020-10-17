package com.ciechu.brewdogrecipes.core.di

import androidx.room.Room
import com.ciechu.brewdogrecipes.core.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "beerRecipesDb"
        ).build()
    }

    single { get<AppDatabase>().beerDao() }
}
