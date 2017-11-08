package com.example.lf_wannabe.managemybook.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lf_wannabe.managemybook.R
import com.example.lf_wannabe.managemybook.model.Book

/**
 * Created by mangob on 2017. 11. 7..
 */
class VookFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var book = arguments.getSerializable("BOOK") as Book

        var root: View?
        when(book) {
            null -> root = inflater?.inflate(R.layout.fragment_vook_empty, container, false)
            else -> root = inflater?.inflate(R.layout.fragment_vook_item, container, false)
        }

        return root
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
