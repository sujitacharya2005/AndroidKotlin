package com.sa.achitecuturalcomponents.network.paging

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class AlbumViewModel(application: Application) : AndroidViewModel(application) {
    val dataSourceFactory = AlbumDataSourceFactory()
    var liveData : LiveData<PagedList<Photoos>>
    init {
        liveData = LivePagedListBuilder<Int, Photoos>(
            dataSourceFactory,
            10).build()
    }
}