package com.sa.achitecuturalcomponents.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sa.achitecuturalcomponents.R

class ServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
    }
    fun startNormalService(v:View) {
        startActivity(Intent(v.context, NormalServiceActivity::class.java))
    }
}
