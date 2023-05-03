package com.example.paintapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scheduleDailyNotification()
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.paint -> {
                    // Handle click on home button
                    val intent = Intent(this, PaintAct::class.java)
                    startActivity(intent)
                    true
                }

//                R.id.drawings -> {
//                    // Handle click on home button
//                    val intent = Intent(this, YourWork::class.java)
//                    startActivity(intent)
//                    true
//                }

                R.id.notes -> {
                    // Handle click on profile button
                    val intent = Intent(this, NotesList::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
        fun draw(view: View) {
            val i = Intent(this, PaintAct::class.java)
            startActivity(i)
        }
    fun write(view: View) {
        val i = Intent(this, WriteAct::class.java)
        startActivity(i)
    }
    fun work(view: View) {
        val i = Intent(this, YourWork::class.java)
        startActivity(i)
    }

//        fun payment(view: View) {
//            val i = Intent(this, Payment::class.java)
//            startActivity(i)
//        }
//        fun schedule(view: View) {
//            val i = Intent(this, Schedule::class.java)
//            startActivity(i)
//        }
//        fun help(view: View) {
//            val i = Intent(this, Help::class.java)
//            startActivity(i)
//        }
//        fun statements(view: View) {
//            val i = Intent(this, Statements::class.java)
//            startActivity(i)
//        }

    private fun scheduleDailyNotification() {
        val notificationHelper = NotificationHelper(this)

        val notificationIntent = Intent(this, NotificationsBroadcastReceiver::class.java)
        notificationIntent.action = "daily_notification"

        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        // Set the notification to trigger at 8:00 AM every day
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        calendar.set(Calendar.HOUR_OF_DAY, 8)
        calendar.set(Calendar.MINUTE, 0)

        alarmManager.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
    }
}