package com.example.vermvvm.view

interface AuthInterface {

    fun onStarted()
    fun onFailure(message : String)
    fun onSuccess(success : String)
}