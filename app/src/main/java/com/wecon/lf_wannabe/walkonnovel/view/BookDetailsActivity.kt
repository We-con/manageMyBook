package com.wecon.lf_wannabe.walkonnovel.view

import android.os.Bundle
import android.support.v4.view.ViewPager
import com.wecon.lf_wannabe.walkonnovel.BaseActivity
import com.wecon.lf_wannabe.walkonnovel.R
import com.wecon.lf_wannabe.walkonnovel.util.DummyFactory
import com.wecon.lf_wannabe.walkonnovel.view.adapter.DetailsPagerAdapter
import kotlinx.android.synthetic.main.activity_book_details.*
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by mangob on 2017. 11. 22..
 */

class BookDetailsActivity : BaseActivity() {

    private lateinit var adapter: DetailsPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        // adapter
        adapter = DetailsPagerAdapter(supportFragmentManager, DummyFactory.createBookDummy())

        // viewpager
        bookDetailsViewPager.adapter = adapter
    }
}