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
            addBookContentTextTitle.text = book.let {
                it.title = it.title.replace(reg, "")
                it.title
            }
            addBookContentTextAuthor.text = book.let {
                it.author = it.author.replace(reg, "")
                it.author
            }
            addBookContentTextPublisher.text = book.let {
                it.publisher = it.publisher.replace(reg, "")
                it.publisher
            }
            glide.load(book.image).into(addBookContentImgThumnail)
        }
    }
}
