package com.sa.achitecuturalcomponents.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class NormalService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }
}
