package com.ciechu.brewdogrecipes.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.navigation.navOptions
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ciechu.brewdogrecipes.R
import com.ciechu.brewdogrecipes.core.navigation.FragmentNavigator
import com.ciechu.brewdogrecipes.core.navigation.FragmentNavigatorImpl
import com.ciechu.brewdogrecipes.core.network.NetworkStateProvider
import com.ciechu.brewdogrecipes.core.network.NetworkStateProviderImpl
import com.ciechu.brewdogrecipes.core.provider.ActivityProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    factory { LinearLayoutManager(this.androidContext()) }
    factory { DividerItemDecoration(this.androidContext(), LinearLayoutManager.VERTICAL) }

    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }

    single(createdAtStart = true) { ActivityProvider(androidApplication()) }
    factory<FragmentNavigator> {
        FragmentNavigatorImpl(
            activityProvider = get(),
            navHostFragmentRes = R.id.nav_host_fragment,
            homeDestinationRes = R.id.beerListFragment,
            defaultNavOptions = get()
        )
    }
    factory {
        navOptions {
            anim { enter = R.anim.fragment_fade_enter }
            anim { exit = R.anim.fragment_fade_exit }
            anim { popEnter = R.anim.fragment_open_enter }
            anim { popExit = R.anim.fragment_open_exit }
        }
    }
}