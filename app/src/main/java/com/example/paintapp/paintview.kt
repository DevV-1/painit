package com.example.paintapp

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import com.example.paintapp.PaintAct.Companion.paintbrsh
import com.example.paintapp.PaintAct.Companion.path

class paintview: View {
    companion object {
        var pathTrack= ArrayList<Path>() /* keeps track of path drawn */
        var colors= ArrayList<Int>() /* list of colors, colors return int as value */
        var currentcolor= Color.BLACK /* default color ar first then change according to what is clicked */

    }
    //    constructors copied as used same in all files
    constructor(context: Context) : this(context, null) {
        fxn()
    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs,0) {
        fxn()
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        fxn()
    }
    private fun fxn() {
        paintbrsh.isAntiAlias=true //for smooth stroke
        paintbrsh.strokeWidth=8f
        paintbrsh.strokeJoin=Paint.Join.ROUND //for end of each stroke to be in round shape
        paintbrsh.style=Paint.Style.STROKE //paint style stroke
        paintbrsh.color= currentcolor


    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x= event.x
        var y= event.y

        when(event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x,y)
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                path.lineTo(x,y)
                pathTrack.add(path)
                colors.add(currentcolor)
            }
            else -> return false
        }
        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas) {
        for (i in pathTrack.indices) {
            paintbrsh.setColor(colors[i])
            canvas.drawPath(pathTrack[i], paintbrsh)
            invalidate()
        }
//    private val STROKE_WIDTH= 10f
//    private var path= Path()
//    val drawColor= Color.BLACK
//    private val backgroundColor= Color.WHITE
//    private lateinit var extraCanvas: Canvas
//    private lateinit var extraBitmap: Bitmap
//    private lateinit var frame: Rect
//    private val paint= Paint().apply {
//        color= drawColor
//        isAntiAlias= true
//        isDither= true
//        style= Paint.Style.STROKE
//        strokeWidth= STROKE_WIDTH
//    }
//    private val touchTolerance= ViewConfiguration.get(context).scaledTouchSlop
//    private var currentX=0f
//    private var currentY=0f
//    private var motionTouchEventX=0f
//    private var motionTouchEventY=0f
//
//    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
//        super.onSizeChanged(w, h, oldw, oldh)
//        if(::extraBitmap.isInitialized) extraBitmap.recycle()
//        extraBitmap= Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888)
//        extraCanvas= Canvas(extraBitmap)
//        extraCanvas.drawColor(backgroundColor)
//        val inset=40
//        frame= Rect(inset,inset,width-inset,height-inset)
//    }
//
//    override fun onDraw(canvas: Canvas?) {
//        canvas?.drawBitmap(extraBitmap,0f,0f,null)
//        extraCanvas.drawRect(frame,paint)
//    }
//
//    override fun onTouchEvent(event: MotionEvent): Boolean {
//        motionTouchEventX=event.x
//        motionTouchEventY=event.y
//        when (event.action) {
//            MotionEvent.ACTION_DOWN -> touchStart()
//            MotionEvent.ACTION_MOVE -> touchMove()
//            MotionEvent.ACTION_UP -> touchUp()
//        }
//        return true
//    }
//
//    private fun touchStart() {
//        path.reset()
//        path.moveTo(motionTouchEventX,motionTouchEventY)
//        currentX=motionTouchEventX
//        currentY=motionTouchEventY
//    }
//
//    private fun touchMove() {
//        val dx= Math.abs(motionTouchEventX-currentX)
//        val dy= Math.abs(motionTouchEventY-currentY)
//        if(dx>=touchTolerance || dy>=touchTolerance) {
//            path.quadTo(
//                currentX,currentY,(motionTouchEventX+currentX)/2,(motionTouchEventY+currentY)/2
//            )
//            currentX=motionTouchEventX
//            currentY=motionTouchEventY
//            extraCanvas.drawPath(path,paint)
//        }
//        invalidate()
//    }
//
//    private fun touchUp() {
//        path.reset()
    }
}