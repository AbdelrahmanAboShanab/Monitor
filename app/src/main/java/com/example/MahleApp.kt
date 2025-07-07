package com.example

//import com.google.firebase.crashlytics.FirebaseCrashlytics
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MahleApp : Application() {

    override fun onCreate() {
        super.onCreate()

    }

}