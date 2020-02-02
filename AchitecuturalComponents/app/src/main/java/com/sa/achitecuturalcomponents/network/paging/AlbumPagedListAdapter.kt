package com.sa.achitecuturalcomponents.network.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sa.achitecuturalcomponents.R

class AlbumPagedListAdapter : PagedListAdapter<Photoos, AlbumPagedListAdapter.AlbumViewHoler>(diffCallBack) {


    class AlbumViewHoler(parent:ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.photo_item,  parent, false)) {
        private val titleTxtView = itemView.findViewById<TextView>(R.id.title)

        fun bindTo(photoos: Photoos?) {
            titleTxtView.text = photoos?.title
        }
    }


    companion object {
        private val diffCallBack = object :DiffUtil.ItemCallback<Photoos>() {
            override fun areItemsTheSame(oldItem: Photoos, newItem: Photoos): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Photoos, newItem: Photoos): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHoler {
        return AlbumViewHoler(parent)
    }

    override fun onBindViewHolder(holder: AlbumViewHoler, position: Int) {
        holder.bindTo(getItem(position))
    }
}