package com.example.lf_wannabe.managemybook.view

import android.os.Bundle
import com.example.lf_wannabe.managemybook.BaseActivity
import com.example.lf_wannabe.managemybook.R

/**
 * Created by lf_wannabe on 07/11/2017.
 */
class AddBookActivity: BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        setTitle("책추가")
        setNavi()
    }
}