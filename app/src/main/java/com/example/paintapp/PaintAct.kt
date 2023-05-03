package com.example.paintapp

import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import com.example.paintapp.paintview.Companion.colors
import com.example.paintapp.paintview.Companion.currentcolor
import com.example.paintapp.paintview.Companion.pathTrack
import java.text.SimpleDateFormat
import java.util.*

class PaintAct : AppCompatActivity() {
    companion object {  //declaring global variables
        var path= Path()
        var paintbrsh= Paint()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paint)
//        val d=paintview(this) //linking paintview.kt
//        setContentView(d)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(R.layout.my_dialog_layout)

        var cbtn = findViewById<ImageButton>(R.id.colorbtn)
        var ebtn = findViewById<ImageButton>(R.id.erasebtn)
        var rbtn = findViewById<ImageButton>(R.id.rbtn)
        var pbtn = findViewById<ImageButton>(R.id.pbtn)
        var bbtn = findViewById<ImageButton>(R.id.bbtn)

        cbtn.setOnClickListener() {
            rbtn.visibility = View.VISIBLE
            pbtn.visibility = View.VISIBLE
            bbtn.visibility = View.VISIBLE
        }
        ebtn.setOnClickListener() {
            pathTrack.clear()
            colors.clear()
            path.reset()

        }
        rbtn.setOnClickListener() {
            paintbrsh.color = Color.RED
            colorchanger(paintbrsh.color)
        }
        pbtn.setOnClickListener() {
            paintbrsh.color = Color.rgb(102, 51, 153)
            colorchanger(paintbrsh.color)
        }
        bbtn.setOnClickListener() {
            paintbrsh.color = Color.BLUE
            colorchanger(paintbrsh.color)
        }
        val paintView = findViewById<View>(R.id.paint_view)
        val sharedPreferences = getSharedPreferences("my_work", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        editor.putInt(currentDate, R.id.paint_view)
        editor.apply()


}
    private fun colorchanger(color:Int) {
        currentcolor= color
        path=Path()
    }


}