package com.wecon.lf_wannabe.walkonnovel

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.toolbar_test.*

/**
 * Created by lf_wannabe on 06/11/2017.
 */

open class BaseActivity : AppCompatActivity() {

    protected fun setTitle(title: String){
        toolbarTextTitle.text = title
    }

    protected fun setNavi(){
        toolbarImgNavi.visibility = View.VISIBLE
        toolbarImgNavi.setOnClickListener { finish() }
    }

    open fun initToolbar(){ }

    protected fun setAction(onClickListener: View.OnClickListener) {
        toolbarImgAct.visibility = View.VISIBLE
        toolbarImgAct.setOnClickListener(onClickListener)
    }


    protected fun setConfirmAction(onClickListener: (View) -> Unit) {
        toolbarImgConFirmAct.visibility = View.VISIBLE
        toolbarImgConFirmAct.setOnClickListener(onClickListener)
    }

    protected fun startActivity(activityClass: Class<out Activity>) {
        startActivity(Intent(this, activityClass))
    }
}