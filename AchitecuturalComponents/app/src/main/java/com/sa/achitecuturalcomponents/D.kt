package com.sa.achitecuturalcomponents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class D : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)
    }
    fun clickMe(view: View) {
        val intent = Intent(this, B::class.java)
        startActivity(intent)
    }
}
