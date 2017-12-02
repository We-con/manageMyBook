package com.wecon.lf_wannabe.walkonnovel.view

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import com.wecon.lf_wannabe.walkonnovel.BaseActivity
import com.wecon.lf_wannabe.walkonnovel.R
import com.wecon.lf_wannabe.walkonnovel.view.adapter.BookGridAdpater
import com.wecon.lf_wannabe.walkonnovel.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.view.*

/**
 * Created by mangob on 2017. 11. 26..
 */
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: BookViewModel
    private lateinit var adapter: BookGridAdapter
    private var searchFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // viewmodel
        viewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)

        // adapter for gridview
        adapter = BookGridAdapter()
        adapter.update(viewModel.readAll())

        // gridview
        mainGridView.adapter = adapter
        mainGridView.setOnItemClickListener { parent, view, position, id ->
            var intent = Intent(this, BookDetailsActivity::class.java)
            startActivity(intent)
        }

        // Search
        with(mainToolbar) {
            toolbarImgAct.setOnClickListener {
                when(searchFlag) {
                    false -> {
                        toolbarTextDesc.visibility = View.INVISIBLE
                        toolbarEditSearch.visibility = View.VISIBLE
                    }
                    true -> {
                        toolbarTextDesc.visibility = View.VISIBLE
                        toolbarEditSearch.visibility = View.INVISIBLE
                    }
                }
                searchFlag = !searchFlag
            }
        }
    }
}