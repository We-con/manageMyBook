package com.wecon.lf_wannabe.walkonnovel.view

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import com.wecon.lf_wannabe.walkonnovel.BaseActivity
import com.wecon.lf_wannabe.walkonnovel.R
import com.wecon.lf_wannabe.walkonnovel.view.adapter.BookGridAdpater
import com.wecon.lf_wannabe.walkonnovel.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_test.*

/**
 * Created by mangob on 2017. 11. 26..
 */
class TestActivity : BaseActivity() {

    private lateinit var viewModel: BookViewModel

//    private var dp = this.resources.displayMetrics.density

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        // viewmodel
        viewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)

        // toolbar
        setTitle("Vook")

        // GridView
        testGridView.adapter = BookGridAdpater(viewModel.readAll())
    }
}