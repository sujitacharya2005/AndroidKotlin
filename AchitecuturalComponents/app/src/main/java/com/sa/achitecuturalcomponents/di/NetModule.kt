package com.sa.achitecuturalcomponents.di

import com.sa.achitecuturalcomponents.network.JsonPlaceHolderService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//https://github.com/ihsanbal/LoggingInterceptor/blob/master/app/src/main/java/ihsanbal/com/logginginterceptor/di/NetModule.java

@Module
class NetModule {


    @Singleton
    @Provides
    fun provideClient() : OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor();
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC

        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(JsonPlaceHolderService.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }


    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit) : JsonPlaceHolderService {
        return retrofit.create(JsonPlaceHolderService::class.java)
    }
}