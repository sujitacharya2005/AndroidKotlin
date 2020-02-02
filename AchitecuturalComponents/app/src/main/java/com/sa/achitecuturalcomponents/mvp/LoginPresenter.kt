package com.sa.achitecuturalcomponents.mvp

import com.sa.achitecuturalcomponents.R


class LoginPresenter(val view:LoginView, val service: LoginService) {
    fun onButtonClicked() {

        val userName = view.getUsername()
        if(userName.isEmpty()) {
            view.showUsernameError(R.string.username_error)
            return
        }
        val password =  view.getPassWord()
        if(password.isEmpty()) {
            view.showPasswordError(R.string.password_error)
            return
        }
        val loginSuccess = LoginService().login(userName, password)
        if(loginSuccess) {
            view.showSuccess();
        } else {
            view.showError()
        }
    }
}