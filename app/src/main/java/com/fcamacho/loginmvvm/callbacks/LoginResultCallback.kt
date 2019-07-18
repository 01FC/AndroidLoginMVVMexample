package com.fcamacho.loginmvvm.callbacks

interface LoginResultCallback {
    fun onSuccess(message:String?)
    fun onError(message:String?)
}