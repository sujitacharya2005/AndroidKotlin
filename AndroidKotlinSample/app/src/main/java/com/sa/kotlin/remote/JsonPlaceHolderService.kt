package com.sa.kotlin.remote

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface JsonPlaceHolderService {
    @GET("/albums")
    fun getAlbums() : Call<List<Album>>

    @GET("/photos")
    fun getPhotos(@Query("albumId") albumId:Int) : Call<List<Photo>>

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"

        fun create() : JsonPlaceHolderService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(JsonPlaceHolderService::class.java)
        }
    }
}