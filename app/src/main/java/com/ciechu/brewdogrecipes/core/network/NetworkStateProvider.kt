package com.ciechu.brewdogrecipes.core.network

interface NetworkStateProvider {
    fun isNetworkAvailable(): Boolean
}