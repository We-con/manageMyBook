package com.example.lf_wannabe.managemybook.view.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView
import com.example.lf_wannabe.managemybook.R
import io.reactivex.Observable

/**
 * Created by lf_wannabe on 14/11/2017.
 */
class HighlightPenImageView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    companion object {
        val PEN_DEFAULT_THIN = 10
        val PEN_DEFAULT_THIN_RATE = 1f
        val PEN_COLOR_DEFAULT = R.color.penDefaultYellow
        val PEN_REMOVE_COLOR = R.color.penRemoveColor
        val CANCELBOX_SIZE = 5

        val SIMILARITY: Float = 50f
    }
    private var toSave: Boolean = false

    private var thickness: Float = dpToPx(PEN_DEFAULT_THIN)
    private var firstX: Float? = null
    private var firstY: Float? = null
    private var currentX: Float? = null
    private var currentY: Float? = null

    private var currentPaint: Paint
    private var highlightPaint: Paint = Paint()
    private var removePaint: Paint = Paint()

    private var currentLine: Line? = null
    private var lines: ArrayList<Line> = ArrayList()


    init {
        highlightPaint.isDither = true
        highlightPaint.style = Paint.Style.STROKE
        setPenColor(PEN_COLOR_DEFAULT)

        currentPaint = highlightPaint

        removePaint.isDither = true
        removePaint.color = ContextCompat.getColor(context, PEN_REMOVE_COLOR)
        removePaint.style = Paint.Style.STROKE

        setThickness(PEN_DEFAULT_THIN_RATE)
    }

    fun setThickness(rate: Float){
        highlightPaint.strokeWidth = thickness * rate
    }

    fun setPenColor(color: Int){
        highlightPaint.color = ContextCompat.getColor(context, color)
    }
    private fun dpToPx(dp: Int): Float = (dp * resources.displayMetrics.density)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }


    override fun buildDrawingCache() {
        toSave = true
        invalidate()
        super.buildDrawingCache()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

            var cancelBoxSize = dpToPx(CANCELBOX_SIZE).toInt()
            lines.forEach {
                if (!toSave) {
                    var xPos = it.firstX.toInt()
                    var yPos = it.firstY.toInt()

                    var cancelRec = Rect(xPos - cancelBoxSize,
                            yPos - cancelBoxSize,
                            xPos + cancelBoxSize,
                            yPos + cancelBoxSize)
                    removePaint.strokeWidth = it.linePaint.strokeWidth
                    canvas!!.drawRect(cancelRec, removePaint)
                }
                canvas!!.drawLine(it.firstX, it.firstY, it.lastX, it.firstY, it.linePaint)
            }


        currentLine?. let {
            removePaint.strokeWidth = currentPaint.strokeWidth
            canvas!!.drawLine(it.firstX, it.firstY, it.lastX, it.firstY, currentPaint )
        }
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        toSave = false
        var originalX = event!!.x
        var originalY = event!!.y

        when(event!!.action){
            MotionEvent.ACTION_DOWN -> {
                firstX = originalX
                firstY = originalY
                addLine(originalX, originalY)
            }

            MotionEvent.ACTION_MOVE -> {
                currentX = originalX
                currentY = originalY
                drawLine(originalX, originalY)
            }

            MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP -> {
                finishLine()
            }
        }
        invalidate()
        return true
    }

    private fun finishLine(){
        currentLine?. let {
            if (Math.abs(it.firstX - it.lastX) > 100){
                it.linePaint = Paint(currentPaint)
                lines.add(it)
            }
        }
        currentLine = null
    }

    private fun drawLine(x: Float, y: Float){
        currentPaint = highlightPaint
        currentLine?. let {
            it.lastX = x
            it.lastY = y
        }
    }

    private fun addLine(x: Float, y: Float){
        for (line in lines){
            if (sameLine(line, x, y)){
                currentLine = line
                lines.remove(line)
                return
            }
        }

        currentLine = Line(x, y, x, y)
    }

    private fun sameLine(line: Line, x: Float, y: Float): Boolean{
        var diffX = Math.abs(line.firstX - x)
        var diffY = Math.abs(line.firstY - y)
        return  diffX < SIMILARITY && diffY < SIMILARITY
    }
}