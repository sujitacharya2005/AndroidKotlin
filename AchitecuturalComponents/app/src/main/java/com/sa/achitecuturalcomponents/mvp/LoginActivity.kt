package com.sa.achitecuturalcomponents.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sa.achitecuturalcomponents.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    fun onLoginClicked(view:View) {
        val userName = user_name.text.toString()
        val passWord = user_password.text.toString()
        if(userName.isEmpty()) {
            user_name.error = "User name error"
            return
        }
        if(passWord.isEmpty()) {
            user_password.error = "Password error"
            return
        }
        val success = LoginService().login(userName, passWord)
        if(success) {
            Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show()
        }

    }
}
