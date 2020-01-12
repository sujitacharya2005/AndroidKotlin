package com.sa.achitecuturalcomponents.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface JsonPlaceHolderService {
   @GET("/albums")
   fun getAlbums() : Call<List<Album>>

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }

//        var okHttpClientBuilder = OkHttpClient.Builder()
//        var gsonFactory= GsonConverterFactory.create()
//
//
//        fun create() : JsonPlaceHolderService {
//            var loggingInterceptor = HttpLoggingInterceptor();
//            loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
//
//            okHttpClientBuilder.addInterceptor(loggingInterceptor)
//            val retrofit = Retrofit.Builder()
//                .addConverterFactory(gsonFactory)
//                .baseUrl(BASE_URL)
//                .client(okHttpClientBuilder.build())
//                .build();
//
//            return retrofit.create(JsonPlaceHolderService::class.java)
//        }
//    }
}