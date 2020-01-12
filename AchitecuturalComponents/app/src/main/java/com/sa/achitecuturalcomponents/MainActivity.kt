package com.sa.achitecuturalcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sa.achitecuturalcomponents.network.Album
import com.sa.achitecuturalcomponents.network.JsonPlaceHolderService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    companion object {
         const val TAG: String = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonPlaceHolderService = JsonPlaceHolderService.create()
        val call = jsonPlaceHolderService.getAlbums()
        call.enqueue(object : Callback<List<Album>> {
            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                Log.e(TAG,"onFailure : ${t.cause}")
            }

            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                Log.v(TAG,"onResponse : ${response.body()}")
            }

        })
    }
}
