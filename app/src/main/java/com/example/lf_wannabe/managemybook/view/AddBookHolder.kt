package com.example.lf_wannabe.managemybook.view

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.lf_wannabe.managemybook.commons.BaseViewHolder
import com.example.lf_wannabe.managemybook.model.Book
import kotlinx.android.synthetic.main.item_add_book_content.view.*

/**
 * Created by lf_wannabe on 08/11/2017.
 */
class AddBookHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun onBind(glide: RequestManager, book: Book) {
        with(itemView){
            addBookContentTextTitle.text = book.title
            addBookContentTextAuthor.text = book.author
            glide.load(book.thumnail).into(addBookContentImgThumnail)
        }
    }
}