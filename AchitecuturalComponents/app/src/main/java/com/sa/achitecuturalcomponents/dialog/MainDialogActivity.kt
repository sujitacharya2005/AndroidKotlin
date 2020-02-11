package com.sa.achitecuturalcomponents.dialog

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sa.achitecuturalcomponents.R


class MainDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dialog)

    }

    fun buttonClick(v: View) {
        val dialogClickListener =
            DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        //Yes button clicked
                        Toast.makeText(this, "Yes",Toast.LENGTH_SHORT).show()
                    }
                    DialogInterface.BUTTON_NEGATIVE -> {
                        //No button clicked
                        Toast.makeText(this, "Yes",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        with(AlertDialog.Builder(this)) {
            setMessage("Are you sure?")
            setPositiveButton("Yes", dialogClickListener)
            setNegativeButton("No", dialogClickListener)
        }.show()


    }
}
