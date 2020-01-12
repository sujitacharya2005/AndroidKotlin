package com.sa.achitecuturalcomponents.di

import com.sa.achitecuturalcomponents.MainActivity
import com.sa.achitecuturalcomponents.network.JsonPlaceHolderService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetModule::class])
interface NetComponent {
   // fun getApi() :  JsonPlaceHolderService
    fun inject(act:MainActivity)
}