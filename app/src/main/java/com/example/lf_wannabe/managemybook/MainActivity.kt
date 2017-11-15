package com.example.lf_wannabe.managemybook

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.Toast
import com.example.lf_wannabe.managemybook.util.DummyFactory
import com.example.lf_wannabe.managemybook.util.TextFormatUtil
import com.example.lf_wannabe.managemybook.view.AddBookActivity
import com.example.lf_wannabe.managemybook.view.adapter.VookPagerAdapter
import com.example.lf_wannabe.managemybook.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private var viewModel = BookViewModel()
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
        adapter.updateVooks(viewModel.readAll())
        adapter.notifyDataSetChanged()

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
        mainCurrentPage.text = makeCurrentPage(1)

    }

    private fun makeCurrentPage(current: Int): SpannableStringBuilder {
        when(current) {
            1 -> {
                mainArrowLeft.visibility = View.INVISIBLE
                mainArrowRight.visibility = View.VISIBLE
            }
            adapter.count -> {
                mainArrowLeft.visibility = View.VISIBLE
                mainArrowRight.visibility = View.INVISIBLE
            }
            else -> {
                mainArrowLeft.visibility = View.VISIBLE
                mainArrowRight.visibility = View.VISIBLE
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
