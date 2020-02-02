package com.sa.achitecuturalcomponents.network.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

class AlbumDataSourceFactory : DataSource.Factory<Int, Photoos>() {
    val source = MutableLiveData<AlbumPageKeyedDataSource>()
    override fun create(): DataSource<Int, Photoos> {
        val source = AlbumPageKeyedDataSource();
        this.source.postValue(source)
        return source;
    }
}