package com.wecon.lf_wannabe.walkonnovel.view.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.wecon.lf_wannabe.walkonnovel.model.Post
import kotlinx.android.synthetic.main.item_book_details_content.view.*

/**
 * Created by mangob on 2017. 11. 22..
 */
class DetailsPostContentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun update(post: Post) {
        with(itemView) {
            detailsContentTextDate.text = post.date
            detailsContentTextMemory.text = post.memory
        }
    }
}