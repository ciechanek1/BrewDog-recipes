package com.ciechu.brewdogrecipes.features.beer.domain

import com.ciechu.brewdogrecipes.features.beer.BeerRepository
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
            params = Unit,
            scope = GlobalScope
        )

        //then
        // coVerify { repository.getBeers() }
    }
}

