package com.example.paintapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationManagerCompat

class NotificationsBroadcastReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "daily_notification") {
            val notificationHelper = NotificationHelper(context)
            val notificationBuilder = notificationHelper.getNotificationBuilder()
            val notificationManager = NotificationManagerCompat.from(context)
            notificationManager.notify(1, notificationBuilder.build())
        }
    }
}
