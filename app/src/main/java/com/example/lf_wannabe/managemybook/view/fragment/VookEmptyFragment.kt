package com.example.lf_wannabe.managemybook.view.fragment

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lf_wannabe.managemybook.R
import com.example.lf_wannabe.managemybook.model.Book

/**
 * Created by mangob on 2017. 11. 17..
 */
class VookEmptyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater!!.inflate(R.layout.fragment_vook_empty, container, false)

        return root
    }

    companion object {
        fun newInstance(): Fragment {
            var fragment = VookEmptyFragment()
            return fragment
        }
    }
}