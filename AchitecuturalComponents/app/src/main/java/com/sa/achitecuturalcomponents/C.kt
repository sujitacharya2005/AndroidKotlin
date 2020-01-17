package com.sa.achitecuturalcomponents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class C : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
    }
    public fun clickMe(view: View) {
        val intent = Intent(this, D::class.java)
        startActivity(intent)
    }
}
