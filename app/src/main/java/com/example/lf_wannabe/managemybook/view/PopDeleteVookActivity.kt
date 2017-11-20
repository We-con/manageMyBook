package com.example.lf_wannabe.managemybook.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.example.lf_wannabe.managemybook.BaseActivity
import com.example.lf_wannabe.managemybook.R
import com.example.lf_wannabe.managemybook.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_pop_delete_vook.*

/**
 * Created by mangob on 2017. 11. 16..
 */
class PopDeleteVookActivity : BaseActivity() {

    private lateinit var viewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_delete_vook)

        viewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)

        var title = intent.getStringExtra("BOOK_TITLE")

        deleteVookClose.setOnClickListener {
            finish()
        }

        deleteVookOk.setOnClickListener {
            viewModel.deleteBook(title)
            finish()
        }
    }


}