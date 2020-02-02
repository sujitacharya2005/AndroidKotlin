package com.sa.achitecuturalcomponents.di

import com.sa.achitecuturalcomponents.MainActivity
import com.sa.achitecuturalcomponents.network.paging.AlbumPageKeyedDataSource
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetModule::class])
interface NetComponent {
   // fun getApi() :  JsonPlaceHolderService
    fun inject(act:MainActivity)
    fun inject(act:AlbumPageKeyedDataSource)
}