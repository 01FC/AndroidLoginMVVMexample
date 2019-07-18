package com.fcamacho.loginmvvm.model

import androidx.databinding.BaseObservable

data class User(
    var mail: String? = ""
    , var pass: String? = ""
) : BaseObservable()