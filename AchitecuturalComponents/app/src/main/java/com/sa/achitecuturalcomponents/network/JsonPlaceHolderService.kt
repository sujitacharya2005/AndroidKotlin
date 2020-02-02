package com.sa.achitecuturalcomponents.network



import com.sa.achitecuturalcomponents.network.paging.Photoos
import retrofit2.http.GET
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Query


interface JsonPlaceHolderService {
   @GET("/albums")
   fun getAlbums() : Observable<List<Album>>

    @GET("/photos")
    fun getPhotos(@Query("albumId" ) albumId:Int) : Call<List<Photoos>>

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