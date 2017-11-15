package com.example.lf_wannabe.managemybook.view

import android.os.Bundle
import android.widget.Toast
import com.example.lf_wannabe.managemybook.BaseActivity
import com.example.lf_wannabe.managemybook.R
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_add_post.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by lf_wannabe on 12/11/2017.
 */
class AddPostActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        initToolbar()
        initWheelView()
    }


    fun initWheelView(){
        var list: ArrayList<String> = ArrayList()
        // ㅎㅎ;
        Observable.range(1, 1000)
                .map { i -> i.toString() }
                .subscribe{ i -> list.add(i)}

        addPostWheelView.items = list
        addPostWheelView.setAdditionCenterMark(".p")
    }

    override fun initToolbar() {
        setTitle("포스트 입력")
        setNavi()
        setConfirmAction {
            Toast.makeText(applicationContext, "Confirm", Toast.LENGTH_SHORT).show()
        }
    }
}