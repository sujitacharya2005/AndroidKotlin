package com.sa.achitecuturalcomponents.mvp

interface LoginView {
    fun getUsername(): String
    fun showUsernameError(resId: Int)
    fun showPasswordError(resId: Int)
    fun getPassWord(): String
    fun showSuccess()
    fun showError()
}
