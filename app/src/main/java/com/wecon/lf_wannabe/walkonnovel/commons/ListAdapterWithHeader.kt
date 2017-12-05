package com.wecon.lf_wannabe.walkonnovel.commons

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import io.realm.RealmObject

/**
 * Created by lf_wannabe on 08/11/2017.
 */
abstract class ListAdapterWithHeader<T: RealmObject, VH: RecyclerView.ViewHolder>(
        val activity: FragmentActivity, protected val hasHeader: Boolean)
    : RecyclerView.Adapter<VH>() {

    protected val HEADER_TYPE: Int = 0
    protected val ITEM_TYPE: Int = 1

    protected var list: ArrayList<T> = ArrayList()
    protected var selectedPosition: Int = -1

    companion object {
        var mOnItemClickListener: OnItemClickListener? = null
    }

    interface OnItemClickListener {
        fun onItemClick(v: View, position: Int) {}
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        mOnItemClickListener = onItemClickListener
    }


    override fun getItemViewType(position: Int): Int {
        return if (hasHeader && position == 0) HEADER_TYPE else ITEM_TYPE
    }

    override fun getItemCount(): Int {
        return list.size + if (hasHeader) 1 else 0
    }

    protected fun getItem(position: Int): T = list[position - if (hasHeader) 1 else 0]

    fun setData(list: ArrayList<T>) {
        this.list = list
        selectedPosition = -1
        notifyDataSetChanged()
    }

    fun setSelected(position: Int) {
        selectedPosition = position
        notifyDataSetChanged()
    }
}
