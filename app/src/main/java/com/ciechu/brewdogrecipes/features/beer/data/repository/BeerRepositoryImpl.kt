package com.ciechu.brewdogrecipes.features.beer.data.repository

import com.ciechu.brewdogrecipes.core.network.NetworkStateProvider
import com.ciechu.brewdogrecipes.features.beer.domain.BeerRepository
import com.ciechu.brewdogrecipes.features.beer.domain.model.Beer
import com.ciechu.brewdogrecipes.features.data.local.BeerDao
import com.ciechu.brewdogrecipes.features.data.local.model.BeerCashed
import com.ciechu.brewdogrecipes.features.data.remote.PunkApi

class BeerRepositoryImpl(
    private val punkApi: PunkApi,
    private val beerDao: BeerDao,
    private val networkStateProvider: NetworkStateProvider
) : BeerRepository {

    override suspend fun getBeers(
        currentQuery: String?,
        currentPage: Int,
        pageSize: Int
    ): List<Beer> {
        return if (networkStateProvider.isNetworkAvailable()) {
            return getBeersFromRemote(currentQuery, currentPage, pageSize)
                .also { saveBeersToLocal(it) }
        } else {
            getBeersFromLocal()
        }
    }

    private suspend fun getBeersFromRemote(
        currentQuery: String?,
        currentPage: Int,
        pageSize: Int
    ): List<Beer> {
        return if (!currentQuery.isNullOrEmpty()) {
            punkApi.getBeersByName(currentPage, pageSize, currentQuery)
                .map { it.toBeer() }
        } else {
            punkApi.getBeers(currentPage, pageSize)
                .map { it.toBeer() }
        }
    }

    private suspend fun saveBeersToLocal(beers: List<Beer>) {
        beers.map { BeerCashed(it) }
            .toTypedArray()
            .let { beerDao.saveBeers(*it) }
    }

    private suspend fun getBeersFromLocal(): List<Beer> {
        return beerDao.getBeers()
            .map { it.toBeer() }
    }
}