package com.wecon.lf_wannabe.walkonnovel.view.adapter

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.wecon.lf_wannabe.walkonnovel.R
import com.wecon.lf_wannabe.walkonnovel.model.Book
import com.wecon.lf_wannabe.walkonnovel.model.TestBook
import com.wecon.lf_wannabe.walkonnovel.view.holder.DetailsPostContentHolder
import com.wecon.lf_wannabe.walkonnovel.view.holder.DetailsPostHeaderHolder

/**
 * Created by mangob on 2017. 11. 22..
 */
class DetailsPostAdapter(var book: TestBook) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val HEADER_TYPE = 0
    private val CONTENT_TYPE = 1

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            HEADER_TYPE -> DetailsPostHeaderHolder(LayoutInflater.from(parent?.context)
                    .inflate(R.layout.item_book_details_header, parent, false) as ConstraintLayout
            )
            else -> DetailsPostContentHolder(LayoutInflater.from(parent?.context)
                    .inflate(R.layout.item_book_details_content, parent, false) as ConstraintLayout
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        when(position) {
            HEADER_TYPE -> (holder as DetailsPostHeaderHolder).update(book)
            else -> (holder as DetailsPostContentHolder).update(book.posts[position-1])
        }
    }

    override fun getItemCount(): Int {
        return book.posts.size+1
    }

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> HEADER_TYPE
            else -> CONTENT_TYPE
        }
    }
}