package com.wecon.lf_wannabe.walkonnovel.view.adapter

import android.support.constraint.ConstraintLayout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.wecon.lf_wannabe.walkonnovel.R
import com.wecon.lf_wannabe.walkonnovel.model.Book
import com.wecon.lf_wannabe.walkonnovel.util.DummyFactory
import com.wecon.lf_wannabe.walkonnovel.view.holder.BookGridHolder

/**
 * Created by mangob on 2017. 11. 26..
 */
class BookGridAdapter : BaseAdapter() {

    private var books: ArrayList<Book>

    init {
        books = ArrayList<Book>().apply {
            add(DummyFactory.createAddBook())
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var item = when(convertView){
            null -> LayoutInflater.from(parent?.context)
                    .inflate(R.layout.item_grid_book, parent, false) as ConstraintLayout
            else -> convertView
        }
        BookGridHolder(item).bind(books[position])

        return item
    }

    override fun getItem(position: Int): Book = books[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getCount(): Int = books.size

    fun update(newBooks: ArrayList<Book>) {
        books = ArrayList<Book>().apply {
            add(DummyFactory.createAddBook())
            addAll(newBooks)
        }
        notifyDataSetChanged()
    }

}