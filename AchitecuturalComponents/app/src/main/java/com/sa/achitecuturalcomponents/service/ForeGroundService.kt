package com.sa.achitecuturalcomponents.service

import android.app.*
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.sa.achitecuturalcomponents.R

class ForeGroundService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val input = intent?.getStringExtra("inputExtra")


        createNotificationChannel()
        val notificationIntent = Intent(this, ForegroundServiceActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this,
                        0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        val CHANNEL_ID = "ForegroundService Example"
        val notification = NotificationCompat.Builder(this, CHANNEL_ID )
            .setContentTitle("Example Service")
            .setContentText(input)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1, notification)


        return START_NOT_STICKY
    }
    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val CHANNEL_ID = "ForegroundService Example"

            val serviceChannel = NotificationChannel(CHANNEL_ID, "Foreground Service Channel",
                                        NotificationManager.IMPORTANCE_DEFAULT)
            val manager = getSystemService(NotificationManager::class.java)
            manager!!.createNotificationChannel(serviceChannel)
        }
    }
}
