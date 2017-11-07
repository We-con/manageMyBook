package com.example.lf_wannabe.managemybook

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by lf_wannabe on 06/11/2017.
 */

open class BaseActivity : AppCompatActivity() {

    protected fun setTitle(title: String){
        toolbarTextTitle.setText(title)
    }

    protected fun setNavi(){
        toolbarImgNavi.visibility = View.VISIBLE
        toolbarImgNavi.setOnClickListener {
            finish()
        }

    }

    protected fun setConfirmAction(onClickListener: View.OnClickListener) {
        toolbarImgConFirmAct.visibility = View.VISIBLE
        toolbarImgConFirmAct.setOnClickListener(onClickListener)
    }

    protected fun startActivity(activityClass: Class<out Activity>) {
        startActivity(Intent(this, activityClass))
    }
}