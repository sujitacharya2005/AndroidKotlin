package com.sa.achitecuturalcomponents.network.paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import com.sa.achitecuturalcomponents.R
import kotlinx.android.synthetic.main.activity_album.*

class AlbumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        val adapter = AlbumPagedListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 3);
        val albumViewModel:AlbumViewModel = ViewModelProviders.of(this).get(AlbumViewModel::class.java)
        albumViewModel.liveData.observe(this, Observer { pagedList->adapter.submitList(pagedList) })

    }
}
