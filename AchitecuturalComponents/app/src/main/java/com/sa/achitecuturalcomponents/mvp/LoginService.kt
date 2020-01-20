package com.sa.achitecuturalcomponents.mvp

class LoginService {

    fun login(userName:String, passWord:String):Boolean {
        return "sujit".equals(userName) && "android".equals(passWord)
    }
}