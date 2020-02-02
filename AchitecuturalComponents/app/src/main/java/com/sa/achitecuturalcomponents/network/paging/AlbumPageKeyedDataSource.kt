package com.sa.achitecuturalcomponents.network.paging

import android.provider.Contacts.Photos
import androidx.paging.PageKeyedDataSource
import com.sa.achitecuturalcomponents.di.DaggerNetComponent
import com.sa.achitecuturalcomponents.network.JsonPlaceHolderService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.adapter.rxjava2.Result.response
import javax.inject.Inject


class AlbumPageKeyedDataSource :PageKeyedDataSource<Int, Photoos>() {
    @Inject
    lateinit var  jsonPlaceHolderService:JsonPlaceHolderService
    init {
        DaggerNetComponent.create().inject(this)
    }
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Photoos>) {
        val call = jsonPlaceHolderService.getPhotos(1)
        call.enqueue(object : Callback<List<Photoos>>{
            override fun onFailure(call: Call<List<Photoos>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Photoos>>, response: Response<List<Photoos>>) {
                val photoList = response.body()?: emptyList()
                callback.onResult(photoList, null, 2 );
            }

        })

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Photoos>) {
        val call = jsonPlaceHolderService.getPhotos(1)
        call.enqueue(object : Callback<List<Photoos>>{
            override fun onFailure(call: Call<List<Photoos>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Photoos>>, response: Response<List<Photoos>>) {
                val photoList = response.body()?: emptyList()
                callback.onResult(photoList, params.key+1);
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Photoos>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}