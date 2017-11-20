package com.wecon.lf_wannabe.walkonnovel.view

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.RequestManager
import com.wecon.lf_wannabe.walkonnovel.model.Book
import kotlinx.android.synthetic.main.item_add_book_content.view.*

/**
 * Created by lf_wannabe on 08/11/2017.
 */
class AddBookHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun onBind(glide: RequestManager, book: Book) {
        var reg = Regex("(<([^>]+)>)")
        with(itemView){
            addBookContentTextTitle.text = book.title.replace(reg, "")
            addBookContentTextAuthor.text = book.author.replace(reg, "")
            addBookContentTextPublisher.text = book.publisher.replace(reg, "")
            glide.load(book.image).into(addBookContentImgThumnail)
        }
    }
}