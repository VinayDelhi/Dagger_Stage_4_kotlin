package com.example.daggerkotlin.ui.home

import com.example.daggerkotlin.data.local.DatabaseService
import com.example.daggerkotlin.data.remote.NetworkService
import com.example.daggerkotlin.di.scope.FragmentScope
import com.example.daggerkotlin.utils.NetworkHelper
import javax.inject.Inject

@FragmentScope
class HomeViewModel @Inject constructor(private val databaseService: DatabaseService,
                    private val networkService: NetworkService,
                    private val networkHelper: NetworkHelper){

    fun getSomeData(): String {
        return (databaseService.getDummyData()
                + " : " + networkService.getDummyData()
                + " : " + networkHelper.isNetworkAvailable())
    }


}