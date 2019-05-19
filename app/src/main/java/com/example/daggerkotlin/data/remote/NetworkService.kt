package com.example.daggerkotlin.data.remote

import android.content.Context
import com.example.daggerkotlin.di.qualifier.ApplicationContext
import com.example.daggerkotlin.di.qualifier.NetworkInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkService @Inject constructor(@ApplicationContext val context: Context, @NetworkInfo val apiKey: String){

    fun getDummyData(): String{

        return "NETWORK_DUMMY_DATA"
    }
}