package com.example.daggerkotlin.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.daggerkotlin.MyApplication
import com.example.daggerkotlin.R
import com.example.daggerkotlin.di.component.DaggerActivityComponent
import com.example.daggerkotlin.di.module.ActivityModule
import com.example.daggerkotlin.ui.home.HomeFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel
    private lateinit var dataTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init();
    }

    private fun init(){
        dataTv = findViewById(R.id.tv_message)
        dataTv.text = mainViewModel.getSomeData()

        addHomeFragment()
    }

    private fun getDependencies(){

        DaggerActivityComponent
                      .builder()
            .applicationComponent((application as MyApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)

        Log.d("DEBUG", mainViewModel.toString())
    }

    private fun addHomeFragment(){

        if(supportFragmentManager.findFragmentByTag(HomeFragment.TAG) == null){

            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_fragment, HomeFragment.newInstance(), HomeFragment.TAG)
                .commit()
        }
    }
}
