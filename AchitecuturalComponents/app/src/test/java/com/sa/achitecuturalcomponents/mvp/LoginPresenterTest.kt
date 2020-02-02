package com.sa.achitecuturalcomponents.mvp

import com.sa.achitecuturalcomponents.R
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class LoginPresenterTest {

    private lateinit var mPresenter: LoginPresenter

    @Mock
    private lateinit var service: LoginService

    @Mock
    private lateinit var view: LoginView


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mPresenter = LoginPresenter(view, service)
    }

    @Test
    fun shouldShowErrorMessageWhenUsernameIsEmpty()  {
        `when`(view.getUsername()).thenReturn("")
        mPresenter.onButtonClicked();
        verify(view).showUsernameError(R.string.username_error)
    }
    @Test
    fun shouldShowErrorMessageWhenPasswordIsEmpty()  {
        `when`(view.getUsername()).thenReturn("dfdf")
        `when`(view.getPassWord()).thenReturn("")
        mPresenter.onButtonClicked();
        verify(view).showPasswordError(R.string.password_error)
    }
    @Test
    fun shouldShowErrorMessageLoginFailed()  {
        `when`(view.getUsername()).thenReturn("dfdf")
        `when`(view.getPassWord()).thenReturn("ddfdf")
        mPresenter.onButtonClicked();
        verify(view).showError()
    }
    @Test
    fun shouldShowErrorMessageLoginSuccess()  {
        `when`(view.getUsername()).thenReturn("sujit")
        `when`(view.getPassWord()).thenReturn("android")
        mPresenter.onButtonClicked();
        verify(view).showSuccess()
    }
}