package com.sa.achitecuturalcomponents.network


import retrofit2.http.GET
import io.reactivex.Observable


interface JsonPlaceHolderService {
   @GET("/albums")
   fun getAlbums() : Observable<List<Album>>

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