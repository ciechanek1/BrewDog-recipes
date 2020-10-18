package com.ciechu.brewdogrecipes.features.beer.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.Test


internal class GetBeerUseCaseTest {

    @Test
    fun `WHEN use case is invoked THAN execute getBeers method from repository`() {
        //given
        val repository = mockk<BeerRepository>(relaxed = true)
        val useCase = GetBeerUseCase(repository)

        //when
        useCase(
            params = String(),
            params2 = String(),
            params3 = String(),
            scope = GlobalScope
        )

        //then
        coVerify { repository.getBeers(String(), String(), String()) }
    }
}


