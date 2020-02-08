package com.sa.achitecuturalcomponents.fragmentbackbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sa.achitecuturalcomponents.R

private const val TAG = "MainFragmentActivity"

class MainFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)
        supportFragmentManager.beginTransaction()
            .add(R.id.container, Fragment1())
            .commit()

    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount > 0) {
            Log.i(TAG, "popping backstack")
            supportFragmentManager.popBackStack()
        }
        else {
            Log.i(TAG, "nothing on backstack, calling super")
            super.onBackPressed()
        }
    }
}
