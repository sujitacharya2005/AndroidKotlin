package com.sa.achitecuturalcomponents

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.sa.achitecuturalcomponents.di.DaggerNetComponent
import com.sa.achitecuturalcomponents.network.Album
import com.sa.achitecuturalcomponents.network.JsonPlaceHolderService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import java.io.IOException
import java.security.Permission
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

        if(!checkPermission(this))
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS),1)
        val projection = arrayOf(
            ContactsContract.Data.CONTACT_ID,
            ContactsContract.Data.DISPLAY_NAME,
                        ContactsContract.Data.DATA1,
                        ContactsContract.Data.DATA2,
                        ContactsContract.Data.DATA3,
                        ContactsContract.Data.MIMETYPE)


        val c = contentResolver.query(ContactsContract.Data.CONTENT_URI, projection,
            null, null,null);
        if(c != null) {
            while (c.moveToNext()) {
                val id = c.getString(c.getColumnIndex(ContactsContract.Data.CONTACT_ID))
                val name = c.getString(c.getColumnIndex(ContactsContract.Data.DISPLAY_NAME))
                val data1 = c.getString(c.getColumnIndex(ContactsContract.Data.DATA1))
                val data2 = c.getString(c.getColumnIndex(ContactsContract.Data.DATA2))
                val data3 = c.getString(c.getColumnIndex(ContactsContract.Data.DATA3))
                val mimeType = c.getString(c.getColumnIndex(ContactsContract.Data.MIMETYPE))
                ContactsContract.CommonDataKinds.Relation.MIMETYPE

                println(" id "+id+" name "+name+" data1 "+data1 +" data2 "+data2 +" data3 "+data3 + " mimeType "+mimeType)
            }
        }

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
        compositeDisposable.add(

        jsonPlaceHolderService.getAlbums()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableObserver<List<Album>>(){
                override fun onComplete() {

                }

                override fun onNext(ans: List<Album>) {
                    Log.w("onNext", ans.toString())
                }

                override fun onError(e: Throwable) {}

            }))
    }
    private val compositeDisposable = CompositeDisposable()
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

            override fun onComplete() {}

            override fun onSubscribe(d: Disposable) {}
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(!compositeDisposable.isDisposed)
            compositeDisposable.dispose()
    }


    fun checkPermission(context: Context) :  Boolean {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED
    }

    public fun clickMe(view: View) {
        val intent = Intent(this, A::class.java)
        startActivity(intent)
    }
}
