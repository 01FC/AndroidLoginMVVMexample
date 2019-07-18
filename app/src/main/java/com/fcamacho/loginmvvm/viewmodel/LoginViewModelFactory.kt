package com.fcamacho.loginmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fcamacho.loginmvvm.callbacks.LoginResultCallback

class LoginViewModelFactory(private val loginListener: LoginResultCallback) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(loginListener) as T
    }
}