package com.ciechu.brewdogrecipes.features.beer.navigator

import com.ciechu.brewdogrecipes.R
import com.ciechu.brewdogrecipes.core.navigation.FragmentNavigator
import com.ciechu.brewdogrecipes.features.beer.all.presentation.model.BeerDisplayable
import com.ciechu.brewdogrecipes.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class BeerNavigatorImplTest {

    @Test
    fun `WHEN openBeersDetails is called THAN invoke navigateTo method of FragmentNavigator with action to navigate to beer details screen AND beer model as arguments`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val beerNavigator: BeerNavigator = BeerNavigatorImpl(fragmentNavigator)
        val beer = BeerDisplayable.mock()
        val slot = slot<Pair<String, BeerDisplayable>>()

        //when
        beerNavigator.openBeerDetails(beer)

        //than
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_beerListFragment_to_beerDetailsFragment,
                capture(slot)
            )
        }
        slot.captured.second shouldBe beer
    }

    @Test
    fun `WHEN goBack is called THAN invoke goBack method of FragmentNavigator`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val beerNavigator: BeerNavigator = BeerNavigatorImpl(fragmentNavigator)

        //when
        beerNavigator.goBack()

        //than
        verify { fragmentNavigator.goBack() }
    }
}
