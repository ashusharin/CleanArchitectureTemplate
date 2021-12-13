package com.shusharin.cleanarchitecture.data.di

import androidx.lifecycle.ViewModel
import com.shusharin.cleanarchitecture.ui.detailScreen.DetailViewModel
import com.shusharin.cleanarchitecture.ui.mainScreen.MainScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface ViewModelModule {

    // TODO: 09.12.2021 Реализовать viewmodelkey
    @IntoMap
    @ViewModelKey(MainScreenViewModel::class)
    @Binds
    fun bindMainViewModel(impl: MainScreenViewModel): ViewModel


    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    @Binds
    fun bindDetailViewModel(impl: DetailViewModel): ViewModel

}