package com.wecon.lf_wannabe.walkonnovel.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wecon.lf_wannabe.walkonnovel.R
import com.wecon.lf_wannabe.walkonnovel.model.Post
import kotlinx.android.synthetic.main.fragment_details_post.view.*
import org.parceler.Parcels

/**
 * Created by mangob on 2017. 12. 1..
 */
class DetailsPostFragment : Fragment() {

    private lateinit var post: Post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        post = Parcels.unwrap(arguments.getParcelable("POST"))
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater!!.inflate(R.layout.fragment_details_post, container, false)

        with(root) {
            detailsPostTextCreated.text = post.initDate
            detailsPostTextComments.text = post.title
        }

        return root
    }

    companion object {
        fun newInstance(post: Post): Fragment {
            var fragment = DetailsPostFragment()
            var args = Bundle()
            args.putParcelable("POST", Parcels.wrap(post))
            fragment.arguments = args
            return fragment
        }
    }
}