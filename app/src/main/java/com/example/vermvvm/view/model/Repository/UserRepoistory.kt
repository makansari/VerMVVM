package com.example.vermvvm.view.model.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.vermvvm.view.model.UserData
import com.example.vermvvm.view.model.network.MyApiClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepoistory {

fun userLogin(usData : UserData) : LiveData<String>{

    val loginResponse = MutableLiveData<String>()
    MyApiClient.MyGetResponse().ApiClientUserLogin(usData)
        .enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.isSuccessful){
                    var myresult = response.body().toString()
                    loginResponse.value = myresult
                    Log.i("mytag", "response Sucess : " + response.body()!!.string())
                }
                else
                {
                    Log.i("mytag", "response failure : " + response.errorBody()!!.string())

                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }

        })
                return loginResponse
}



}