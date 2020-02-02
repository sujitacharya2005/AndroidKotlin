package com.sa.achitecuturalcomponents.mvp

import android.view.View
import androidx.test.rule.ActivityTestRule
import com.sa.achitecuturalcomponents.R
import kotlinx.android.synthetic.main.activity_login.view.*
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class LoginActivityTest {


    private var mActivity: LoginActivity?=null
    @get:Rule
    val activityRule = ActivityTestRule(LoginActivity::class.java)

    @Test fun testLoginActivity1() {
        mActivity = activityRule.activity
        val view = mActivity?.findViewById(R.id.login_button) as View
        Assert.assertNotNull(view)
    }
}