package com.sa.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sa.kotlin.remote.JsonPlaceHolderService
import com.sa.kotlin.remote.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    companion object {
        private val  TAG = MainActivity::class.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get all photos based on album id
        val jsonPlaceHolderService = JsonPlaceHolderService.create()
        val call = jsonPlaceHolderService.getPhotos(1) // for album id = 1
        call.enqueue(object : Callback<List<Photo>>{
            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Log.e(TAG,"onFailure : ${t.cause}")
            }

            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                Log.v(TAG,"onResponse : ${response.body()}")
            }

        })
    }
}
