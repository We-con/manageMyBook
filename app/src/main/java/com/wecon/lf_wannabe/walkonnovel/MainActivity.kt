package com.wecon.lf_wannabe.walkonnovel

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.View
import android.widget.Toast
import com.wecon.lf_wannabe.walkonnovel.util.TextFormatUtil
import com.wecon.lf_wannabe.walkonnovel.view.AddBookActivity
import com.wecon.lf_wannabe.walkonnovel.view.TestActivity
import com.wecon.lf_wannabe.walkonnovel.view.adapter.VookPagerAdapter
import com.wecon.lf_wannabe.walkonnovel.viewmodel.BookViewModel
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
        setTitle("문학을 걷다")
//        setAction(View.OnClickListener { showMessage() })
        // TestActivity
        setAction(View.OnClickListener {
            startActivity(TestActivity::class.java)
        })

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
        updatePageNavigator()
    }

    override fun onResume() {
        super.onResume()
        Log.i("Mangob/Main", "onResume")
        // view pager 갱신
        adapter.updateVooks(viewModel.readAll())

        // page navigator 갱신
        updatePageNavigator()
    }

    private fun updatePageNavigator() {
        // page navigator 갱신
        mainCurrentPage.text = when(adapter.isEmpty) {
            true ->  makeCurrentPage(0)
            false -> makeCurrentPage(mainVookViewPager.currentItem+1)
        }
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
            if(adapter.isEmpty) {
                append(TextFormatUtil.changeSize(" / " + 0, 15))
            } else {
                append(TextFormatUtil.changeSize(" / " + adapter.count, 15))
            }
        }
    }

    private fun showMessage(message: String = "Comming soon") {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
