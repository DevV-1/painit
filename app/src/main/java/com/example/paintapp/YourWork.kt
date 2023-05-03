package com.example.paintapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import java.util.*

class YourWork : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_work)
//        val sharedPreferences = getSharedPreferences("my_work", Context.MODE_PRIVATE)
//        val dates = sharedPreferences.all.keys.toTypedArray()
//        Arrays.sort(dates)
//
//        val listView = findViewById<ListView>(R.id.listView)
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dates)
//        listView.adapter = adapter
//
//        listView.setOnItemClickListener { _, _, position, _ ->
//            val selectedDate = dates[position]
//            val layoutViewId = sharedPreferences.getInt(selectedDate, -1)
//            val layoutView = layoutInflater.inflate(layoutViewId, null)
//            val parentlay=findViewById<LinearLayout>(R.id.layoutviewid)
//            parentlay.addView(layoutView)
//        }
//        val desiredDate = "03/05/2023" // Replace with the date you want to retrieve the layout view for
//        val layoutViewId = sharedPreferences.getInt(desiredDate, -1)
//        if (layoutViewId != -1) {
//            val layoutView = layoutInflater.inflate(layoutViewId, null)
//            // Add the layout view to your parent view as needed
//            val parentlay=findViewById<LinearLayout>(R.id.layoutviewid)
//            parentlay.addView(layoutView)
//        }
    }
}