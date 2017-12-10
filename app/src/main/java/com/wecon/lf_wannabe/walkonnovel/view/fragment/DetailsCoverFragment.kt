package com.wecon.lf_wannabe.walkonnovel.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.wecon.lf_wannabe.walkonnovel.R
import com.wecon.lf_wannabe.walkonnovel.model.Book
import com.wecon.lf_wannabe.walkonnovel.util.TextFormatUtil
import kotlinx.android.synthetic.main.fragment_details_cover.view.*
import kotlinx.android.synthetic.main.item_grid_book.view.*
import org.parceler.Parcels

/**
 * Created by mangob on 2017. 12. 1..
 */
class DetailsCoverFragment : Fragment() {

    private lateinit var book: Book

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        book = Parcels.unwrap(arguments.getParcelable("BOOK"))
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater!!.inflate(R.layout.fragment_details_cover, container, false)

        with(root) {
            detailsCoverTextTitle.text = book.title
            detailsCoverTextAuthor.text = book.author
            detailsCoverTextPub.text = book.publisher
            detailsCoverTextDesc.text = TextFormatUtil.customA(book.initDate, book.posts!!.size)

            when (book.image) {
                null -> Glide.with(root)
                        .load(R.drawable.img_null_book)
                        .into(detailsCoverImg)
                else -> Glide.with(root)
                        .load(book.image)
                        .into(detailsCoverImg)
            }
        }
        return root
    }

    companion object {
        fun newInstance(book: Book): Fragment {
            var fragment = DetailsCoverFragment()
            var args = Bundle()
            args.putParcelable("BOOK", Parcels.wrap(book))
            fragment.arguments = args
            return fragment
        }
    }
}