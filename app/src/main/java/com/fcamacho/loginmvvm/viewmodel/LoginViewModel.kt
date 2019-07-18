package com.fcamacho.loginmvvm.viewmodel

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import androidx.lifecycle.ViewModel
import com.fcamacho.loginmvvm.callbacks.LoginResultCallback
import com.fcamacho.loginmvvm.model.User

class LoginViewModel(val loginListener: LoginResultCallback) : ViewModel() {
    var user: User = User()

    // set Email after user stops setting text
    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user.mail = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // do nothing
            }

        }
    // set Email after user stops setting text
    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user.pass = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }

    // on login button clicked
    fun onLoginClicked(v: View) {
        if (TextUtils.isEmpty(user.mail) ||
            TextUtils.isEmpty(user.pass) ||
            !Patterns.EMAIL_ADDRESS.matcher(user.mail).matches()
        ) {
            loginListener.onError("Do something error")
        } else {
            loginListener.onSuccess("Do something with logged user")
        }
    }
}