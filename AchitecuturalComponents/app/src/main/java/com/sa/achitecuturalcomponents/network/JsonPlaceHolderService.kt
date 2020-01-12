package com.sa.achitecuturalcomponents.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET


interface JsonPlaceHolderService {
   @GET("/albums")
   fun getAlbums() : Call<List<Album>>

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"

        fun create() : JsonPlaceHolderService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
            return retrofit.create(JsonPlaceHolderService::class.java)
        }
    }
}