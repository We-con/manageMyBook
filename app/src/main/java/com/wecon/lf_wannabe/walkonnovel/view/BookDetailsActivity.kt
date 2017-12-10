package com.wecon.lf_wannabe.walkonnovel.view

import android.os.Bundle
import android.support.v4.view.ViewPager
import com.wecon.lf_wannabe.walkonnovel.BaseActivity
import com.wecon.lf_wannabe.walkonnovel.R
import com.wecon.lf_wannabe.walkonnovel.model.Book
import com.wecon.lf_wannabe.walkonnovel.util.DummyFactory
import com.wecon.lf_wannabe.walkonnovel.view.adapter.DetailsPagerAdapter
import kotlinx.android.synthetic.main.activity_book_details.*
import kotlinx.android.synthetic.main.activity_main.*
import org.parceler.Parcels

/**
 * Created by mangob on 2017. 11. 22..
 */

class BookDetailsActivity : BaseActivity() {

    private lateinit var adapter: DetailsPagerAdapter
    private lateinit var book : Book

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        // book
        book = Parcels.unwrap(intent.extras.getParcelable("BOOK"))

        // adapter
        adapter = DetailsPagerAdapter(supportFragmentManager, book)

        // viewpager
        bookDetailsViewPager.adapter = adapter
    }
}