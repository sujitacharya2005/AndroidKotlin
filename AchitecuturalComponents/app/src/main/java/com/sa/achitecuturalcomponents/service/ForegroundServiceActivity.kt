package com.sa.achitecuturalcomponents.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.sa.achitecuturalcomponents.R
import kotlinx.android.synthetic.main.activity_foreground_service.*

class ForegroundServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foreground_service)
    }
    fun startServiceClick(v:View) {
        val intent = Intent(v.context, ForeGroundService::class.java)
        intent.putExtra("inputExtra", editText.text.toString())


        //startService(intent)
        // or

        ContextCompat.startForegroundService(v.context, intent)
    }
    fun stopServiceClick(v:View){
        stopService(Intent(v.context, ForeGroundService::class.java))
    }
}
