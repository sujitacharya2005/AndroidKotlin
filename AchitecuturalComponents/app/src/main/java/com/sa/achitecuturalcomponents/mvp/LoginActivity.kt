package com.sa.achitecuturalcomponents.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sa.achitecuturalcomponents.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() , LoginView{

    lateinit var loginPresenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginPresenter = LoginPresenter(this, LoginService())
    }
    fun onLoginClicked(view:View) {
//        val userName = user_name.text.toString()
//        val passWord = user_password.text.toString()
//        if(userName.isEmpty()) {
//            user_name.error = "User name error"
//            return
//        }
//        if(passWord.isEmpty()) {
//            user_password.error = "Password error"
//            return
//        }
//        val success = LoginService().login(userName, passWord)
//        if(success) {
//            Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show()
//        }

        loginPresenter.onButtonClicked()
    }

    override fun getUsername(): String {
        return user_name.text.toString()
    }

    override fun showUsernameError(resId: Int) {
        user_name.error = getString(R.string.username_error)
    }

    override fun showPasswordError(resId: Int) {
        user_password.error = getString(R.string.password_error)
    }

    override fun getPassWord(): String {
        return user_password.text.toString()
    }

    override fun showSuccess() {
        Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show()
    }

    override fun showError() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show()
    }
}
