package com.wecon.lf_wannabe.walkonnovel.view.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.widget.EditText


class LinedEditText(context: Context, attrs: AttributeSet) : EditText(context, attrs) {
    private val mRect: Rect
    private val mPaint: Paint

    init {
        mRect = Rect()
        mPaint = Paint()
        mPaint.style = Paint.Style.STROKE
        mPaint.color = resources.getColor(android.R.color.black)
    }

    override fun onDraw(canvas: Canvas) {
        val count = lineCount

        for (i in 0 until count) {
            val baseline = getLineBounds(i, mRect)

            canvas.drawLine(mRect.left.toFloat(), (baseline).toFloat()+12, mRect.right.toFloat(), (baseline+12).toFloat(), mPaint)
        }

        super.onDraw(canvas)
    }
}
