package com.example.lf_wannabe.managemybook.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import android.util.Log
import android.view.View
import com.example.lf_wannabe.managemybook.model.Book
import com.example.lf_wannabe.managemybook.view.fragment.VookFragment
import io.realm.RealmList
import io.realm.RealmResults

/**
 * Created by mangob on 2017. 11. 7..
 */
class VookPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private var books: RealmResults<Book> ?= null

    override fun getItem(position: Int): Fragment {
        books?.let {
            return VookFragment.newInstance(it[position])
        } ?: return VookFragment.newInstance(Book())
    }

    override fun getCount(): Int {
        books?.let {
            return it.size
        } ?: return 0

    }

    override fun getItemPosition(`object`: Any?): Int {
        return POSITION_NONE
    }

    fun updateVooks(vooks: RealmResults<Book>) {
        books = vooks
        notifyDataSetChanged()
    }

}