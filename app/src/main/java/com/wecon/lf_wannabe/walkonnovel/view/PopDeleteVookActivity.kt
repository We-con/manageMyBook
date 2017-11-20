package com.wecon.lf_wannabe.walkonnovel.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.wecon.lf_wannabe.walkonnovel.BaseActivity
import com.wecon.lf_wannabe.walkonnovel.R
import com.wecon.lf_wannabe.walkonnovel.viewmodel.BookViewModel
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