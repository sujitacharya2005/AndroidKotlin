package com.sa.achitecuturalcomponents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class B : AppCompatActivity() {

    companion object {
        const val TAG  = "Activity B"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
    }
    fun clickMe(view: View) {
        val intent = Intent(this, C::class.java)
        startActivity(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(TAG, "onNewIntent.....");
    }
    fun clickMeB(view: View) {
        val intent = Intent(this, B::class.java)
        startActivity(intent)
    }
}
