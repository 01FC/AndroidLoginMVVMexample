package com.fcamacho.loginmvvm.`interface`

interface LoginResultCallback {
    fun onSuccess(message:String?)
    fun onError(message:String?)
}