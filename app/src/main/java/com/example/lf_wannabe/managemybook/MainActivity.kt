package com.example.lf_wannabe.managemybook

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.lf_wannabe.managemybook.util.DummyFactory
import com.example.lf_wannabe.managemybook.view.AddBookActivity
import com.example.lf_wannabe.managemybook.view.adapter.VookPagerAdapter
import com.example.lf_wannabe.managemybook.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private var viewMddel = BookViewModel()
    private var adapter = VookPagerAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toolbar 설정
        setTitle("문학소년")
        setAction(View.OnClickListener { showMessage() })

        // Fab 설정
        mainFab.setOnClickListener {
            startActivity(AddBookActivity::class.java)
        }

        // Dummy
        adapter.updateVooks(DummyFactory.createBookDummy())
        adapter.notifyDataSetChanged()

        // ViewPager 설정
        mainVookViewPager.adapter = adapter

    }

    private fun showMessage(message: String = "Comming soon") {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
