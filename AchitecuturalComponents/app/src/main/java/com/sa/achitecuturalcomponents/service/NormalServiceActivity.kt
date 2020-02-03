package com.sa.achitecuturalcomponents.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sa.achitecuturalcomponents.R

class NormalServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_service)
    }
    fun startService(v: View) {
        startService(Intent(v.context, NormalService::class.java ))
    }
    fun stopService(v:View) {
        stopService(Intent(v.context, NormalService::class.java ))
    }

}
