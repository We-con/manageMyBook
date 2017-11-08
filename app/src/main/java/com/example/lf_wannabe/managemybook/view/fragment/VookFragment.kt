package com.example.lf_wannabe.managemybook.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lf_wannabe.managemybook.R
import com.example.lf_wannabe.managemybook.model.Book
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
            vookTextDetails.text = book.author
            vookTextNowPage.text = "P ${book.currentPageNum}"
            vookTextTotalPage.text = "P ${book.totalPageNum}"
            vookTextComments.text = getComments(book.currentPageNum, book.totalPageNum)
        }
    }

    private fun getComments(current: Int, total: Int): String {
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
