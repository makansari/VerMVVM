package com.example.vermvvm.view.view_model

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.vermvvm.view.AuthInterface

class AuthViewModel : ViewModel() {

    var email:String ? = null
    var pwd:String ? = null

    var authlistner : AuthInterface? = null
    fun onLoginButtonClicked(view : View){
            authlistner?.onStarted()
        if(email.isNullOrEmpty() && pwd.isNullOrEmpty()){
            authlistner?.onFailure("Its failed")
        }
        else {
                authlistner?.onSuccess(" succesful")
        }
    }
}