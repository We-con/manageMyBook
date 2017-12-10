package com.wecon.lf_wannabe.walkonnovel.view

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import com.wecon.lf_wannabe.walkonnovel.BaseActivity
import com.wecon.lf_wannabe.walkonnovel.R
import com.wecon.lf_wannabe.walkonnovel.view.adapter.BookGridAdpater
import com.wecon.lf_wannabe.walkonnovel.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.parceler.Parcels

/**
 * Created by mangob on 2017. 11. 26..
 */
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: BookViewModel
    private lateinit var adapter : BookGridAdpater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // viewmodel
        viewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)

        // adapter
        adapter = BookGridAdpater(viewModel.readAll())

        // GridView
        mainGridView.adapter = adapter
        mainGridView.setOnItemClickListener { parent, view, position, id ->
            var intent = when(position) {
                0 -> Intent(this, AddBookActivity::class.java)
                else -> Intent(this, BookDetailsActivity::class.java).apply {
                        putExtra("BOOK", Parcels.wrap(adapter.getItem(position)))
                    }
            }
            startActivity(intent)
        }
    }
}