package com.example.vermvvm.view.view_model

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.vermvvm.view.AuthInterface
import com.example.vermvvm.view.model.Repository.UserRepoistory
import com.example.vermvvm.view.model.UserData

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
                var userData = UserData(email!!,pwd!!)
            val myreponse = UserRepoistory().userLogin(userData)
            authlistner?.onSuccess(myreponse)

        }
    }
}