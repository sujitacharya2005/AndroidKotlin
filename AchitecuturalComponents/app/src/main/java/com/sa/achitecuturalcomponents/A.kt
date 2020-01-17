package com.sa.achitecuturalcomponents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class A : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
    }
    public fun clickMe(view: View) {
        val intent = Intent(this, B::class.java)
        startActivity(intent)
    }
}
