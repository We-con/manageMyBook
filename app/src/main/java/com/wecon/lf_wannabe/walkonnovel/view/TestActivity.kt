package com.wecon.lf_wannabe.walkonnovel.view

import android.os.Bundle
import com.wecon.lf_wannabe.walkonnovel.BaseActivity
import com.wecon.lf_wannabe.walkonnovel.R

/**
 * Created by mangob on 2017. 11. 26..
 */
class TestActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        // toolbar
        setTitle("Vook")
    }
}