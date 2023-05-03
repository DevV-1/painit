package com.example.paintapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class NotificationHelper(private val context: Context) {

    fun getNotificationBuilder(): NotificationCompat.Builder {
        val channelId = "daily_notification_channel"
        val channelName = "Daily Notification"
        val channelDescription = "Receive daily notifications at a specific time"
        val notificationId = 1

        // Create the notification channel for Android Oreo and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.description = channelDescription
            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        // Create the notification builder
        val notificationBuilder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentTitle("PaintIt Reminder")
            .setContentText("Don't forget to show your creativity today!")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        // Set the notification ID
        notificationBuilder.setOnlyAlertOnce(true)
        notificationBuilder.setChannelId(channelId)
        notificationBuilder.setDefaults(Notification.DEFAULT_ALL)
        notificationBuilder.setContentIntent(getPendingIntent())

        return notificationBuilder
    }

    private fun getPendingIntent(): PendingIntent {
        // Create a PendingIntent that will open your app's MainActivity when the notification is clicked
        val intent = Intent(context, MainActivity::class.java)
        return PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }
}