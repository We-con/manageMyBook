package com.example.lf_wannabe.managemybook.view

import android.app.FragmentManager
import android.preference.PreferenceActivity
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.lf_wannabe.managemybook.R
import com.example.lf_wannabe.managemybook.commons.ListAdapterWithHeader
import com.example.lf_wannabe.managemybook.model.Book
import com.example.lf_wannabe.managemybook.utils.CollectionsUtils
import kotlinx.android.synthetic.main.item_add_book_header.view.*

/**
 * Created by lf_wannabe on 08/11/2017.
 */
class AddBookAdapter(ac: FragmentActivity, hasHeader: Boolean)
    : ListAdapterWithHeader<Book, RecyclerView.ViewHolder>(ac, hasHeader){

    private val glide: RequestManager = Glide.with(ac)
    var searchKey: String = "HEADER"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when (viewType) {
                HEADER_TYPE -> createHeaderView(parent)
                else -> AddBookHolder(LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_add_book_content, parent, false))
            }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            HEADER_TYPE ->
                onBindHeaderView(holder)
            ITEM_TYPE -> {
                with(holder!! as AddBookHolder){
                    onBind(glide, getItem(position))

                    with(holder.itemView){
                        setOnClickListener {
                            view -> mOnItemClickListener?.onItemClick(view,
                                layoutPosition + if (hasHeader) -1 else 0)
                        }
                    }
                }
            }
        }
    }

    private fun createHeaderView(parent: ViewGroup): RecyclerView.ViewHolder{
        return HeaderHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_add_book_header, parent, false))
    }

    private fun onBindHeaderView(holder: RecyclerView.ViewHolder){
        (holder as HeaderHolder).onBind(searchKey)
    }

    inner class HeaderHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun onBind(data: String){
            var listNum = itemCount - 1
            itemView.addBookTextHeader.text =
                    if(itemCount==1) "" else "\"${data}\"에 대한 ${listNum}개의 결과"
        }
    }
}