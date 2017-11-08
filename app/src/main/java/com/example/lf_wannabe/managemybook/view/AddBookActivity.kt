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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        initToolbar()

        //TODO: test 목적으로 임의로 Realm을 씀. retrofit이랑 연결해서 쓰도록 해야함
        Realm.init(this)
        var list = Realm.getDefaultInstance().where(Book::class.java).findAll()


        var testadapter = AddBookAdapter(this, true)
        testadapter.setData(list)

        addBookViewSearch.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                getBooks(s.toString())
            }
        })

        with(addBookViewList){
            addItemDecoration(CustomItemDecoration(applicationContext, 20))
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

    //TODO : reactive하게 바꿔보자
    fun getBooks(searchKey: String){
        var call: Call<List<Book>> = bookService.getBooks(searchKey)

        Log.d("MIM", bookService.getBooks(searchKey).request().url().toString())

        call.enqueue(object: Callback<List<Book>>{
            override fun onResponse(call: Call<List<Book>>?, response: Response<List<Book>>?) {
                Log.d("MIM", "오예!!")
            }

            override fun onFailure(call: Call<List<Book>>?, t: Throwable?) {
                Log.d("MIM", "통신실패 ㅠㅠ")
            }
        })

    }
}