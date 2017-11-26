package com.wecon.lf_wannabe.walkonnovel.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.wecon.lf_wannabe.walkonnovel.model.Book
import com.wecon.lf_wannabe.walkonnovel.view.fragment.VookEmptyFragment
import com.wecon.lf_wannabe.walkonnovel.view.fragment.VookItemFragment
import io.realm.RealmList

/**
 * Created by mangob on 2017. 11. 7..
 */
class VookPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private var books: ArrayList<Book> ?= null
    var isEmpty: Boolean = true

    override fun getItem(position: Int): Fragment {
        books?.let {
            return when (isEmpty) {
                true -> VookEmptyFragment.newInstance()
                false -> VookItemFragment.newInstance(it[position])
            }
        } ?: return VookEmptyFragment.newInstance()
    }

    override fun getCount(): Int {
        books?.let {
            return it.size
        } ?: return 0

    }

    override fun getItemPosition(`object`: Any?): Int {
        return POSITION_NONE
    }

    fun updateVooks(vooks: ArrayList<Book>) {
        isEmpty = vooks.isEmpty()

        books = when(isEmpty) {
            true -> ArrayList<Book>().apply { add(Book()) }
            false -> vooks
        }
        notifyDataSetChanged()
    }

}