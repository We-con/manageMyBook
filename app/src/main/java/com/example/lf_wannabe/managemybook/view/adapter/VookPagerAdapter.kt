package com.example.lf_wannabe.managemybook.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import com.example.lf_wannabe.managemybook.model.Book
import com.example.lf_wannabe.managemybook.view.fragment.VookFragment
import io.realm.RealmList
import io.realm.RealmResults

/**
 * Created by mangob on 2017. 11. 7..
 */
class VookPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private var books: RealmList<Book> = RealmList<Book>()

    override fun getItem(position: Int): Fragment {
        return when(books.size) {
            0 -> VookFragment.newInstance(null)
            else -> VookFragment.newInstance(books[position])
        }
    }

    override fun getCount(): Int {
        return books.size
    }

    fun updateVooks(vooks: RealmList<Book>) {
        books = vooks
    }

}