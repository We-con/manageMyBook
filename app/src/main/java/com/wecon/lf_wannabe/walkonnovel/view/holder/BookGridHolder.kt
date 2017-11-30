package com.wecon.lf_wannabe.walkonnovel.view.holder

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.wecon.lf_wannabe.walkonnovel.model.Book
import kotlinx.android.synthetic.main.item_grid_book.view.*

/**
 * Created by mangob on 2017. 11. 26..
 */
class BookGridHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(book: Book) {
        with(itemView) {
            if(book.author == "admin" && book.publisher == "admin") {
                itemGridBookLayout.visibility = View.INVISIBLE
            } else {
                itemGridBookTextTitle.text = book.title
                itemGridBookTextPublisher.text = book.publisher
                itemGridBookTextAuthor.text = book.author
            }
            makeThumbnail(book.image)
        }
    }

    private fun makeThumbnail(url: String) {
        when(url) {
            "thumnail", "null", "image", null -> Glide.with(itemView)
                    .load("http://cfile6.uf.tistory.com/image/254F4D39584407823880F8")
                    .into(itemView.itemGridBookImgThumbnail)
            else -> Glide.with(itemView)
                    .load(url)
                    .into(itemView.itemGridBookImgThumbnail)
        }
        itemView.itemGridBookImgThumbnail.clipToOutline = true
    }
}