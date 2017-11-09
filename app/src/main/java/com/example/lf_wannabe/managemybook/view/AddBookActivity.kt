package com.example.lf_wannabe.managemybook.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.lf_wannabe.managemybook.BaseActivity
import com.example.lf_wannabe.managemybook.R
import com.example.lf_wannabe.managemybook.commons.CustomItemDecoration
import com.example.lf_wannabe.managemybook.model.Book
import com.example.lf_wannabe.managemybook.model.BookList
import com.example.lf_wannabe.managemybook.network.BookService
import io.realm.Realm
import io.realm.RealmObject
import kotlinx.android.synthetic.main.activity_add_book.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by lf_wannabe on 07/11/2017.
 */
class AddBookActivity: BaseActivity(){
    private var bookService: BookService = BookService.retrofit.create(BookService::class.java)
    lateinit var listAdapter: AddBookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        initToolbar()

        addBookViewSearch.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                getBooks(s.toString())
            }
        })

        listAdapter = AddBookAdapter(this, true)
        with(addBookViewList){
            addItemDecoration(CustomItemDecoration(applicationContext, 20))

            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(applicationContext)
            addOnScrollListener(object: RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                }
            })

            adapter = listAdapter
        }

    }

    private fun initToolbar(){
        setTitle("책추가")
        setNavi()
        setConfirmAction { Toast.makeText(applicationContext, "Confirm", Toast.LENGTH_SHORT).show() }
    }

    fun getBooks(searchKey: String){
        var call: Call<BookList> = bookService.getBooks(searchKey)

        call.enqueue(object: Callback<BookList>{
            override fun onResponse(call: Call<BookList>, response: Response<BookList>) {
                //TODO : getter setter는 왜 존재하는가...?
                //XXX : response가 null인 경우는 뭐지??
                var list = response.body()!!.books as ArrayList<Book>
                listAdapter.setData(list)
            }

            override fun onFailure(call: Call<BookList>, t: Throwable?) {
                Log.d("MIM", t?.stackTrace.toString())
            }
        })

    }
}