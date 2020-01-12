package com.sa.achitecuturalcomponents

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sa.achitecuturalcomponents.di.DaggerNetComponent
import com.sa.achitecuturalcomponents.network.Album
import com.sa.achitecuturalcomponents.network.JsonPlaceHolderService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import java.io.IOException
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    companion object {
         const val TAG: String = "MainActivity"
    }
    @Inject
    public lateinit var jsonPlaceHolderService:JsonPlaceHolderService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerNetComponent.create().inject(this)
        //val jsonPlaceHolderService = JsonPlaceHolderService.create()
       // val jsonPlaceHolderService = DaggerNetComponent.create().getApi()

//        call.enqueue(object : Callback<List<Album>> {
//            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
//                Log.e(TAG,"onFailure : ${t.cause}")
    //            }
//
//            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
//                Log.v(TAG,"onResponse : ${response.body()}")
//            }
//
//        })
        jsonPlaceHolderService.getAlbums()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(getSubscriber());

    }
    fun getSubscriber(): Observer<List<Album>> {
        return object : Observer<List<Album>> {
            fun onCompleted() {}
            override fun onError(e: Throwable) {}
            override fun onNext(responseBody: List<Album>) {
                try {
                    Log.w("onNext", responseBody.toString())
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {

            }
        }
    }

}
