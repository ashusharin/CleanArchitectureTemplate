package com.shusharin.cleanarchitecture.data.di

import androidx.lifecycle.ViewModel
import com.shusharin.cleanarchitecture.ui.mainScreen.MainScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface ViewModelModule {

    @IntoMap
    @StringKey("MainScreenViewModel")
    @Binds
    fun bindListTripViewModel(impl: MainScreenViewModel): ViewModel

}