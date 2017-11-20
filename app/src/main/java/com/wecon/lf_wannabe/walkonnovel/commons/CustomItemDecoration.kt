package com.wecon.lf_wannabe.walkonnovel.commons

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by lf_wannabe on 08/11/2017.
 */
class CustomItemDecoration : RecyclerView.ItemDecoration {
    private val ATTRS = intArrayOf(android.R.attr.listDivider)
    private val divHeight: Int
    private lateinit var divider: Drawable

    constructor(divHeight: Int) {
        this.divHeight = divHeight
    }

    constructor(context: Context, divHeight: Int) {
        this.divHeight = divHeight
        val styledAttributes = context.obtainStyledAttributes(ATTRS)
        divider = styledAttributes.getDrawable(0)
        styledAttributes.recycle()
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
//        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = divHeight
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + divider!!.intrinsicHeight

            divider.setBounds(left, top, right, bottom)
            divider.draw(c)
        }
    }
}
