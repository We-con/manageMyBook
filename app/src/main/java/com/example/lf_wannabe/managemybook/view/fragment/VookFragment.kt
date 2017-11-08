package com.example.lf_wannabe.managemybook.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lf_wannabe.managemybook.R
import com.example.lf_wannabe.managemybook.model.Book
import com.example.lf_wannabe.managemybook.util.TextFormatUtil
import kotlinx.android.synthetic.main.fragment_vook_item.view.*

/**
 * Created by mangob on 2017. 11. 7..
 */
class VookFragment : Fragment() {

    private lateinit var book: Book

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        book = arguments.getSerializable("BOOK") as Book

        val root = inflater!!.inflate(R.layout.fragment_vook_item, container, false)

        bindData(root)

        return root
    }

    private fun bindData(root: View) {
        with(root) {
            vookTextTitle.text = book.title
            vookTextDetails.text = makeDetails(book.author, book.publisher)
            vookTextNowPage.text = "P ${book.currentPageNum}"
            vookTextTotalPage.text = "P ${book.totalPageNum}"
            vookTextComments.text = makeComments(book.currentPageNum, book.totalPageNum)
        }
    }

    private fun makeDetails(author: String, publisher: String): SpannableStringBuilder {
        var author = SpannableString(author).let {
            TextFormatUtil.changeSize(it, 15)
            TextFormatUtil.changeColor(it, ContextCompat.getColor(context, R.color.colorTextBody1))
        }

        var unitAuthor = SpannableString(" 지음").let {
            TextFormatUtil.changeSize(it, 12)
            TextFormatUtil.changeColor(it, ContextCompat.getColor(context, R.color.colorTextBody2))
        }

        var divider = SpannableString("  |  ").let {
            TextFormatUtil.changeSize(it, 12)
            TextFormatUtil.changeColor(it, ContextCompat.getColor(context, R.color.colorTextBody2))
        }

        var publisher = SpannableString(publisher).let {
            TextFormatUtil.changeSize(it, 15)
            TextFormatUtil.changeColor(it, ContextCompat.getColor(context, R.color.colorTextBody1))
        }

        var unitPublisher = SpannableString(" 펴냄").let {
            TextFormatUtil.changeSize(it, 12)
            TextFormatUtil.changeColor(it, ContextCompat.getColor(context, R.color.colorTextBody2))
        }

        return SpannableStringBuilder().apply {
            append(author)
            append(unitAuthor)
            append(divider)
            append(publisher)
            append(unitPublisher)
        }
    }

    private fun makeComments(current: Int, total: Int): String {
        var progress = (current*100)/total
        if(progress <= 0) { progress = 0 }
        else if(progress < 100) { progress = progress/10 + 1 }
        else { progress = 11 }

        return resources.getStringArray(R.array.vook_comments)[progress]
    }

    companion object {
        fun newInstance(book: Book?): Fragment {
            var fragment = VookFragment()
            fragment.arguments = Bundle().apply {
                putSerializable("BOOK", book)
            }
            return fragment
        }
    }
}
