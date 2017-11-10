package com.example.lf_wannabe.managemybook.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.lf_wannabe.managemybook.BaseActivity
import com.example.lf_wannabe.managemybook.R
import com.example.lf_wannabe.managemybook.commons.CustomItemDecoration
import com.example.lf_wannabe.managemybook.commons.ListAdapterWithHeader
import com.example.lf_wannabe.managemybook.model.Book
import com.example.lf_wannabe.managemybook.model.BookList
import com.example.lf_wannabe.managemybook.network.BookService
import com.example.lf_wannabe.managemybook.viewmodel.BookViewModel
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
    lateinit var list: ArrayList<Book>
    private lateinit var glide: RequestManager
    private var selectedBook: Book? = null
    //TODO: 초기화방법 찾아봐야한다 /ViewModelProviders.of(this)
    //아직 MVVM 구현에 대한 이해가 부족한듯.. 스터디할것
    private lateinit var bookVM: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        initToolbar()
        glide = Glide.with(this)
        bookVM = ViewModelProviders.of(this).get(BookViewModel::class.java)

        addBookViewSearch.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                getBooks(s.toString())
                selectedBook = null
            }
        })

        listAdapter = AddBookAdapter(this, true)
        //TODO: 람다식으로 표현 못하나?
        listAdapter.setOnItemClickListener(object: ListAdapterWithHeader.OnItemClickListener{
            override fun onItemClick(v: View, position: Int) {
                selectedBook = list[position]
                glide.load(selectedBook!!.image).into(addBookViewThumnail)
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

            adapter = listAdapter
        }

    }

    private fun initToolbar(){
        setTitle("책추가")
        setNavi()
        setConfirmAction {
            selectedBook?. let {
                bookVM.insertOrUpdateBook(it)
                finish()
            } ?: Toast.makeText(applicationContext, "추가할 책을 선택해주세요", Toast.LENGTH_SHORT).show()
        }
    }

    fun getBooks(searchKey: String){
        var call: Call<BookList> = bookService.getBooks(searchKey)

        call.enqueue(object: Callback<BookList>{
            override fun onResponse(call: Call<BookList>?, response: Response<BookList>?) {
                //TODO : getter setter는 왜 존재하는가...?
                response!!.body()?. let {
                    list = it.books as ArrayList<Book>
                    listAdapter.setData(list)
                }
            }


            override fun onFailure(call: Call<BookList>, t: Throwable?) {
                Log.d("MIM", t?.stackTrace.toString())
            }
        })

    }
}