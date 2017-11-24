package com.wecon.lf_wannabe.walkonnovel.view.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.wecon.lf_wannabe.walkonnovel.R
import com.wecon.lf_wannabe.walkonnovel.model.Book
import com.wecon.lf_wannabe.walkonnovel.util.TextFormatUtil
import com.wecon.lf_wannabe.walkonnovel.view.BookDetailsActivity
import com.wecon.lf_wannabe.walkonnovel.view.PopDeleteVookActivity
import kotlinx.android.synthetic.main.fragment_vook_item.view.*
import org.parceler.Parcels

/**
 * Created by mangob on 2017. 11. 7..
 */
class VookItemFragment : Fragment() {
    private lateinit var book: Book

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        book = Parcels.unwrap <Book> (arguments.getParcelable(ARG_BOOK))

        val root = inflater!!.inflate(R.layout.fragment_vook_item, container, false)

        bindData(root)

        return root
    }

    private fun bindData(root: View) {
        with(root) {
            vookImgDelete.setOnClickListener {
                var intent = Intent(context, PopDeleteVookActivity::class.java).apply {
                    Log.i("Mangob/vookFragment", book.title)
                    putExtra("BOOK_TITLE", book.title)
                }
                startActivity(intent)
            }
            vookImgBook.setOnClickListener {
                var intent = Intent(context, BookDetailsActivity::class.java)
                startActivity(intent)
            }
            makeThumnNail(root, book.image)
            vookTextTitle.text = book.title
            vookTextDetails.text = makeDetails(book.author, book.publisher)
            vookTextNowPage.text = "P ${book.currentPageNum}"
            vookTextTotalPage.text = "P ${book.totalPageNum}"
            vookTextComments.text = makeComments(book.currentPageNum, book.totalPageNum)
        }
    }

    private fun makeThumnNail(root: View, url: String) {
        Glide.with(root)
                .load(R.drawable.img_book_sample)
                .into(root.vookImgBook)
        root.vookImgBook.clipToOutline = true
    }

    private fun makeDetails(author: String, publisher: String): SpannableStringBuilder {
        var author = SpannableString(author).let {
            TextFormatUtil.changeSize(it, 15)
            TextFormatUtil.changeColor(it, ContextCompat.getColor(context, R.color.colorTextBody1))
        }

        var unitAuthor = SpannableString(" 지음").let {
            TextFormatUtil.changeColor(it, ContextCompat.getColor(context, R.color.colorTextBody2))
            TextFormatUtil.changeSize(it, 12)
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
            TextFormatUtil.changeSize(it, 10)
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
        var ARG_BOOK = "ARG_BOOK"
        fun newInstance(book: Book?): Fragment {
            var fragment = VookItemFragment()
            fragment.arguments = Bundle().apply {
                putParcelable(ARG_BOOK, Parcels.wrap(Book::class.java, book))
            }
            return fragment
        }
    }
}
