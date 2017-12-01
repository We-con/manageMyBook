package com.wecon.lf_wannabe.walkonnovel.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wecon.lf_wannabe.walkonnovel.R

/**
 * Created by mangob on 2017. 12. 1..
 */
class DetailsCoverFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater!!.inflate(R.layout.fragment_details_cover, container, false)
        return root
    }

    companion object {
        fun newInstance(): Fragment {
            var fragment = DetailsCoverFragment()
            return fragment
        }
    }
}