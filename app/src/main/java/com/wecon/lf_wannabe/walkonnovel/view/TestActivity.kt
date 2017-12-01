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
import kotlinx.android.synthetic.main.activity_test.*

/**
 * Created by mangob on 2017. 11. 26..
 */
class TestActivity : AppCompatActivity() {

    private lateinit var viewModel: BookViewModel

//    private var dp = this.resources.displayMetrics.density

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        // viewmodel
        viewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)

        // toolbar
//        setTitle("문학을 걷다")

        // GridView
        testGridView.adapter = BookGridAdpater(viewModel.readAll())
        testGridView.setOnItemClickListener { parent, view, position, id ->
            var intent = Intent(this, BookDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}