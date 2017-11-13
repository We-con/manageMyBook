package com.example.lf_wannabe.managemybook.view

import android.os.Bundle
import android.widget.Toast
import com.example.lf_wannabe.managemybook.BaseActivity

/**
 * Created by lf_wannabe on 12/11/2017.
 */
class AddPostActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }




    override fun initToolbar() {
        setTitle("포스트 입력")
        setNavi()
        setConfirmAction {
            Toast.makeText(applicationContext, "Confirm", Toast.LENGTH_SHORT).show()
        }
    }
}