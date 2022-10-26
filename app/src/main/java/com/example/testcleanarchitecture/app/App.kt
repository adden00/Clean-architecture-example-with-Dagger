package com.example.testcleanarchitecture.app

import android.app.Application
import com.example.testcleanarchitecture.di.AppComponent
import com.example.testcleanarchitecture.di.AppModule
import com.example.testcleanarchitecture.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(context = this)).build()
    }
}