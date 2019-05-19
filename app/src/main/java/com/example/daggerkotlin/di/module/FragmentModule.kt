package com.example.daggerkotlin.di.module

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.daggerkotlin.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment){

    @ApplicationContext
    @Provides
    fun provideContext(): Context{
        return fragment.requireContext()
    }
}