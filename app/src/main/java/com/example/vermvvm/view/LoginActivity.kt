package com.example.vermvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.vermvvm.R
import com.example.vermvvm.databinding.ActivityMainBinding
import com.example.vermvvm.view.view_model.AuthViewModel

class LoginActivity : AppCompatActivity(),AuthInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding :ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        var myViewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.layoutViewmodel = myViewModel
        myViewModel.authlistner = this

    }

    override fun onStarted() {
        Toast.makeText(this,"Its STARTED",Toast.LENGTH_SHORT).show()
    }

    override fun onFailure(message: String) {
        Toast.makeText(this,"Its failuer $message",Toast.LENGTH_SHORT).show()

    }

    override fun onSuccess(success: String) {
        Toast.makeText(this,"Its success $success",Toast.LENGTH_SHORT).show()

    }
}