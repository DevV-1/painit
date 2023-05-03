package com.example.paintapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashSet

class WriteAct : AppCompatActivity() {
//    private lateinit var dateTextView: TextView
//    private lateinit var dataEditText: EditText
//    private lateinit var saveButton: Button
private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
        // Initialize views
//        dateTextView = findViewById(R.id.date_text_view)
//        dataEditText = findViewById(R.id.data_edit_text)
//        saveButton = findViewById(R.id.save_button)
//
//        // Set date
//        val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
//        dateTextView.text = currentDate
//
//        // Set click listener for save button
//        saveButton.setOnClickListener {
//            saveData()
//        }
//    }
//
//    private fun saveData() {
//        val sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE)
//        val editor = sharedPreferences.edit()
//
//        // Get current date
//        val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
//
//        // Get data from EditText
//        val data = dataEditText.text.toString()
//
//        // Get existing data for current date
//        val existingData = sharedPreferences.getStringSet(currentDate, HashSet<String>())
//
//        // Add new data to existing data
//        existingData?.add(data)
//
//        // Save updated data for current date
//        editor.putStringSet(currentDate, existingData)
//        editor.apply()
//
//        // Clear EditText
//        dataEditText.setText("")
//
//        // Show success message
//        val message = "Data saved successfully for $currentDate"
//        showToast(message)
//    }
//
//    private fun showToast(message: String) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        sharedPreferences = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

//        val displayDataButton = findViewById<Button>(R.id.displayDataButton)
//        displayDataButton.setOnClickListener {
//            val intent = Intent(this, NotesList::class.java)
//            startActivity(intent)
//        }

//        val saveDataButton = findViewById<Button>(R.id.saveDataButton)
//        saveDataButton.setOnClickListener {
////            val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
//            val dataEditText = findViewById<EditText>(R.id.dataEditText)
//            val data = dataEditText.text.toString()
////
////            editor.putString(currentDate, data)
////            editor.apply()
//            val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
//            val sharedPref = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
//            val editor = sharedPref.edit()
//            val existingData = sharedPref.getString(currentDate, "")
//            val newData = "$existingData$data\n"
//            editor.putString(currentDate, newData)
//            editor.apply()
//
//            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show()
//        }
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home_button -> {
                    // Handle click on home button
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.save_button -> {
                    // Handle click on search button
                    val dataEditText = findViewById<EditText>(R.id.dataEditText)
                    val data = dataEditText.text.toString()
//
//            editor.putString(currentDate, data)
//            editor.apply()
                    val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
                    val sharedPref = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    val existingData = sharedPref.getString(currentDate, "")
                    val newData = "$existingData$data\n"
                    editor.putString(currentDate, newData)
                    editor.apply()

                    Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.notes_button -> {
                    // Handle click on profile button
                        val intent = Intent(this, NotesList::class.java)
                        startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}