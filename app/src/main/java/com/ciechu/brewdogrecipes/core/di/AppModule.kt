package com.ciechu.brewdogrecipes.core.di

import android.content.Context
import android.net.ConnectivityManager
import com.ciechu.brewdogrecipes.core.network.NetworkStateProvider
import com.ciechu.brewdogrecipes.core.network.NetworkStateProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
}