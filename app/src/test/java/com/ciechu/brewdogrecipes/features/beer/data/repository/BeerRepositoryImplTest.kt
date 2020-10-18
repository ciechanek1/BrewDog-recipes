package com.ciechu.brewdogrecipes.features.beer.data.repository

import com.ciechu.brewdogrecipes.core.network.NetworkStateProvider
import com.ciechu.brewdogrecipes.features.beer.domain.BeerRepository
import com.ciechu.brewdogrecipes.features.data.local.BeerDao
import com.ciechu.brewdogrecipes.features.data.local.model.BeerCashed
import com.ciechu.brewdogrecipes.features.data.remote.PunkApi
import com.ciechu.brewdogrecipes.features.data.remote.model.BeerRemote
import com.ciechu.brewdogrecipes.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

internal class BeerRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN beers request THEN fetch beers from API`() {
        //given
        val api = mockk<PunkApi> {
            coEvery { getBeers(1, 10) } returns listOf(BeerRemote.mock())
        }
        val beerDao = mockk<BeerDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository: BeerRepository =
            BeerRepositoryImpl(api, beerDao, networkStateProvider)

        //when
        runBlocking { repository.getBeers("", 1, 10) }

        //then
        coVerify { api.getBeers(1, 10) }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN beers request THEN save beers to local database`() {
        //given
        val api = mockk<PunkApi> {
            coEvery { getBeers(1, 10) } returns listOf(BeerRemote.mock())
        }
        val beerDao = mockk<BeerDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository: BeerRepository =
            BeerRepositoryImpl(api, beerDao, networkStateProvider)

        //when
        runBlocking { repository.getBeers("", 1, 10) }

        //then
        coVerify { beerDao.saveBeers(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN beers request THEN fetch beers from local database`() {
        //given
        val api = mockk<PunkApi>(relaxed = true)
        val beerDao = mockk<BeerDao> {
            coEvery { getBeers() } returns listOf(BeerCashed.mock(), BeerCashed.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }

        val repository: BeerRepository =
            BeerRepositoryImpl(api, beerDao, networkStateProvider)

        //when
        runBlocking { repository.getBeers("", 1, 10) }

        //then
        coVerify { beerDao.getBeers() }
    }
}

