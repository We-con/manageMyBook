package com.wecon.lf_wannabe.walkonnovel.view.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.wecon.lf_wannabe.walkonnovel.model.Book
import com.wecon.lf_wannabe.walkonnovel.model.TestBook
import kotlinx.android.synthetic.main.item_book_details_header.view.*

/**
 * Created by mangob on 2017. 11. 22..
 */
class DetailsPostHeaderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun update(book: TestBook) {
        with(itemView) {
            detailsHeaderTextTitle.text = book.title
            detailsHeaderTextAuthor.text = book.author
            detailsHeaderTextPublisher.text = book.publisher
        }
    }
}