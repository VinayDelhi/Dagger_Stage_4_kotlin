package com.example.daggerkotlin.utils

import android.content.Context
import com.example.daggerkotlin.di.qualifier.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHelper @Inject constructor(@ApplicationContext val context : Context){


    fun isNetworkAvailable() : Boolean{

        return false
    }
}