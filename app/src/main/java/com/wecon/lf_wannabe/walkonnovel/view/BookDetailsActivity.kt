package com.wecon.lf_wannabe.walkonnovel.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.wecon.lf_wannabe.walkonnovel.BaseActivity
import com.wecon.lf_wannabe.walkonnovel.R
import com.wecon.lf_wannabe.walkonnovel.model.TestBook
import com.wecon.lf_wannabe.walkonnovel.util.DummyFactory
import com.wecon.lf_wannabe.walkonnovel.view.adapter.DetailsPostAdapter
import com.wecon.lf_wannabe.walkonnovel.view.adapter.SpacesItemDecoration
import kotlinx.android.synthetic.main.activity_book_details.*

/**
 * Created by mangob on 2017. 11. 22..
 */

class BookDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        // toolbar
        setTitle("책 상세")
        setNavi()

        // adapter
        Log.i("Mangob/BookDetails", "Adapter")
        bookDetailsRecyclerView.layoutManager = LinearLayoutManager(this)
        bookDetailsRecyclerView.addItemDecoration(SpacesItemDecoration(10))
        bookDetailsRecyclerView.adapter = DetailsPostAdapter(DummyFactory.createBookDummy())
    }
}