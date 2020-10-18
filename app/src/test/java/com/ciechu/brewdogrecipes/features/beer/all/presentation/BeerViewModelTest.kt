package com.ciechu.brewdogrecipes.features.beer.all.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.ciechu.brewdogrecipes.core.base.UiState
import com.ciechu.brewdogrecipes.features.beer.domain.GetBeerUseCase
import com.ciechu.brewdogrecipes.features.beer.domain.model.Beer
import com.ciechu.brewdogrecipes.features.beer.navigator.BeerNavigator
import com.ciechu.brewdogrecipes.mock.mock
import com.ciechu.brewdogrecipes.utils.ViewModelTest
import com.ciechu.brewdogrecipes.utils.getOrAwaitValue
import com.ciechu.brewdogrecipes.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.Test

internal class BeerViewModelTest : ViewModelTest() {

    @Test
      fun `WHEN beers live data is observed THEN invoke use case to get beers`() {
        //given
        val useCase = mockk<GetBeerUseCase>(relaxed = true)
        val beerNavigator = mockk<BeerNavigator>(relaxed = true)
        val viewModel = BeerViewModel(useCase, beerNavigator)

        //when
        viewModel.beers.observeForTesting()

        //then
        verify { useCase(String(), String(), String(), viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `WHEN beers live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetBeerUseCase>(relaxed = true)
        val beerNavigator = mockk<BeerNavigator>(relaxed = true)
        val viewModel = BeerViewModel(useCase, beerNavigator)

        //when
        viewModel.beers.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `GIVEN use case result is success WHEN beers live data is observed THEN set idle state AND set result in live data`() {
        //given
        val beers = listOf(Beer.mock(), Beer.mock(), Beer.mock())
        val beerNavigator = mockk<BeerNavigator>(relaxed = true)
        val useCase = mockk<GetBeerUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Beer>>) -> Unit>()(Result.success(beers))
            }
        }
        val viewModel = BeerViewModel(useCase, beerNavigator)

        //when
        viewModel.beers.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.beers.getOrAwaitValue().forEachIndexed { index, beerDisplayable ->
            val beers = beers[index]
            beerDisplayable.abv shouldBe beers.abv
            beerDisplayable.description shouldBe beers.description
            beerDisplayable.ebc shouldBe beers.ebc
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN beers live data is observed THEN set idle state AND show error message`() {
        //given
        val throwable = Throwable("Ops... Something went wrong")
        val beerNavigator = mockk<BeerNavigator>(relaxed = true)
        val useCase = mockk<GetBeerUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Beer>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel = BeerViewModel(useCase, beerNavigator)

        //when
        viewModel.message.observeForever(observer)
        viewModel.beers.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}