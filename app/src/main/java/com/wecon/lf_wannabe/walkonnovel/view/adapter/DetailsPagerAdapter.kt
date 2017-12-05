package com.wecon.lf_wannabe.walkonnovel.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.wecon.lf_wannabe.walkonnovel.model.Book
import com.wecon.lf_wannabe.walkonnovel.view.fragment.DetailsCoverFragment
import com.wecon.lf_wannabe.walkonnovel.view.fragment.DetailsPostFragment

/**
 * Created by mangob on 2017. 12. 1..
 */
class DetailsPagerAdapter(fm: FragmentManager, var book: Book) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> DetailsCoverFragment.newInstance()
            else -> DetailsPostFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return when(book.posts) {
            null -> 1
            else -> book.posts!!.size + 1
        }
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    fun updateBook(book: Book) {
        this.book = book
        notifyDataSetChanged()
    }

}
