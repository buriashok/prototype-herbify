package com.example.sample_one

import HerbalNode
import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.cos
import kotlin.math.hypot
import kotlin.math.sin

class HerbalGardenView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val nodePaint = Paint().apply {
        color = Color.parseColor("#4CAF50")
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    private val textPaint = Paint().apply {
        color = Color.WHITE
        textSize = 28f
        textAlign = Paint.Align.CENTER
        isAntiAlias = true
    }

    private val linePaint = Paint().apply {
        color = Color.BLACK
        strokeWidth = 4f
    }

    private val nodes = mutableListOf<HerbalNode>()

    init {
        // Root herb node
        val root = HerbalNode(width/2f, 200f, "Neem")
        nodes.add(root)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw connections
        for (node in nodes) {
            if (node.isExpanded) {
                for (neighbor in node.neighbors) {
                    canvas.drawLine(node.x, node.y, neighbor.x, neighbor.y, linePaint)
                }
            }
        }

        // Draw nodes
        for (node in nodes) {
            canvas.drawCircle(node.x, node.y, 50f, nodePaint)
            canvas.drawText(node.label, node.x, node.y + 10f, textPaint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val touchedNode = nodes.find {
                Math.hypot((it.x - event.x).toDouble(), (it.y - event.y).toDouble()) < 50
            }

            touchedNode?.let {
                if (!it.isExpanded) {
                    expandNode(it)
                }
            }
            return true
        }
        return super.onTouchEvent(event)
    }

    private fun expandNode(node: HerbalNode) {
        val radius = 200f
        val numberOfNewNodes = 4
        val angleStep = 360 / numberOfNewNodes

        for (i in 0 until numberOfNewNodes) {
            val angle = Math.toRadians((angleStep * i).toDouble())
            val newX = (node.x + radius * Math.cos(angle)).toFloat()
            val newY = (node.y + radius * Math.sin(angle)).toFloat()
            val newNode = HerbalNode(newX, newY, "Herb ${(1..100).random()}")
            nodes.add(newNode)
            node.neighbors.add(newNode)
        }

        node.isExpanded = true
        invalidate()
    }
}
