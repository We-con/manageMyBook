package com.example.lf_wannabe.managemybook

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.lf_wannabe.managemybook.util.TextFormatUtil
import com.example.lf_wannabe.managemybook.view.AddBookActivity
import com.example.lf_wannabe.managemybook.view.adapter.VookPagerAdapter
import com.example.lf_wannabe.managemybook.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var viewModel: BookViewModel
    private var adapter = VookPagerAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // viewmodel
        viewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)

        // Toolbar 설정
        setTitle("문학소년")
        setAction(View.OnClickListener { showMessage() })

        // Fab 설정
        mainFab.setOnClickListener {
            startActivity(AddBookActivity::class.java)
        }

        // realm 연동
        adapter.updateVooks(viewModel.readAll())

        // ViewPager 설정
        mainVookViewPager.adapter = adapter
        mainVookViewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                mainCurrentPage.text = makeCurrentPage(position+1)
            }
        })

        // pager navigator
        if(adapter.count > 0) {
            mainCurrentPage.text = makeCurrentPage(1)
        } else {
            mainCurrentPage.text = makeCurrentPage(0)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.i("Mangob/Main", "onResume")
        // view pager 갱신
        adapter.updateVooks(viewModel.readAll())
    }

    private fun makeCurrentPage(current: Int): SpannableStringBuilder {
        if(current == 0) {
            mainArrowLeft.visibility = View.INVISIBLE
            mainArrowRight.visibility = View.INVISIBLE
        } else {
            mainArrowLeft.visibility = View.VISIBLE
            mainArrowRight.visibility = View.VISIBLE
            if(current == 1) {
                mainArrowLeft.visibility = View.INVISIBLE
            }
            if(current == adapter.count) {
                mainArrowRight.visibility = View.INVISIBLE
            }
        }

        return SpannableStringBuilder().apply {
            if(current < 10) {
                append(TextFormatUtil.changeStyle("  " + current.toString(), 0))
            } else {
                append(TextFormatUtil.changeStyle(current.toString(), 0))
            }
            append(TextFormatUtil.changeSize(" / " + adapter.count, 15))
        }
    }

    private fun showMessage(message: String = "Comming soon") {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
