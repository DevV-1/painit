package com.example.paintapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class NotesList : AppCompatActivity() {
//    private lateinit var dataList: MutableList<String>
//    private lateinit var adapter: ArrayAdapter<String>
private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_list)
        // Set up the adapter to display the data in the ListView
//        dataList = mutableListOf()
//        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList)
//        val listView = findViewById<ListView>(R.id.data_list)
//        listView.adapter = adapter
//
//        // Set up the calendar view and listener
//        val calendarView = findViewById<CalendarView>(R.id.calendar_view)
//        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
//            val selectedDate = "${year}-${month+1}-${dayOfMonth}"
//            displayDataForDate(selectedDate)
//        }
//    }
//
//    // Display the data for the selected date
//    private fun displayDataForDate(date: String) {
//        // Retrieve the data for the selected date from shared preferences and update the adapter
//        val prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
//        dataList.clear()
//        val value = prefs.getString(date, null)
//        if (value != null) {
//            dataList.add("$date: $value")
//        }
//        adapter.notifyDataSetChanged()
//    }
//
//    // Handle the selection of a date in the calendar view
//    fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
//        val selectedDate = "${year}-${month+1}-${dayOfMonth}"
//        displayDataForDate(selectedDate)

        val dataTextView = findViewById<TextView>(R.id.displayview)
    sharedPreferences = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
    val dates = sharedPreferences.all.keys.toTypedArray()
    Arrays.sort(dates)

    val listView = findViewById<ListView>(R.id.listView)
    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dates)
    listView.adapter = adapter

    listView.setOnItemClickListener { _, _, position, _ ->
        val selectedDate = dates[position]
        var data = sharedPreferences.getString(selectedDate, "")
        dataTextView.text = data
    }

    }
}