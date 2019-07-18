package com.fcamacho.loginmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.fcamacho.loginmvvm.callbacks.LoginResultCallback
import com.fcamacho.loginmvvm.viewmodel.LoginViewModel
import com.fcamacho.loginmvvm.viewmodel.LoginViewModelFactory

class MainActivity : AppCompatActivity(), LoginResultCallback {
    override fun onSuccess(message: String?) {
        Toast.makeText(this, "Success: $message", Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String?) {
        Toast.makeText(this, "Error: $message", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val activityBinding = DataBindingUtil.setContentView<com.fcamacho.loginmvvm.databinding.ActivityMainBinding>(
            this
            , R.layout.activity_main
        )
        activityBinding.viewModel = ViewModelProviders.of(
            this
            , LoginViewModelFactory(this)
        ).get(LoginViewModel::class.java)

    }
}
