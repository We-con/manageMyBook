package com.example.lf_wannabe.managemybook.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.lf_wannabe.managemybook.BaseActivity
import com.example.lf_wannabe.managemybook.R
import com.example.lf_wannabe.managemybook.model.Book
import io.realm.Realm
import io.realm.RealmObject
import kotlinx.android.synthetic.main.activity_add_book.*

/**
 * Created by lf_wannabe on 07/11/2017.
 */
class AddBookActivity: BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        initToolbar()

        //TODO: test 목적으로 임의로 Realm을 씀. retrofit이랑 연결해서 쓰도록 해야함
        var list = Realm.getDefaultInstance().where(Book::class.java).findAll()


        var testadapter = AddBookAdapter(this, true)
        testadapter.setData(list)

        with(addBookViewList){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(applicationContext)
            addOnScrollListener(object: RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                }
            })
            adapter = testadapter
        }

    }

    private fun initToolbar(){
        setTitle("책추가")
        setNavi()
        //TODO: 좀 더 코틀린스럽게??
        setConfirmAction(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(applicationContext, "Confirm", Toast.LENGTH_SHORT).show()
            }
        })
    }
}