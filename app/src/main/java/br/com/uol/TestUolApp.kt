package br.com.uol

import android.app.Application

class TestUolApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AppDelegate.onCreate(this)
    }
}