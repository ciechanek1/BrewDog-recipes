package com.ciechu.brewdogrecipes.features.beer.data.repository

import com.ciechu.brewdogrecipes.features.beer.BeerRepository
import com.ciechu.brewdogrecipes.features.beer.domain.model.Beer
import com.ciechu.brewdogrecipes.features.data.remote.PunkApi

class BeerRepositoryImpl(
    private val punkApi: PunkApi
) : BeerRepository {

    override suspend fun getBeers(
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
}