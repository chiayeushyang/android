package com.firstapp.activity_lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivityLog"
    var isLoggedIn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate" )
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart" )
        super.onRestart()
    }

    override fun onStart() {
        Log.d(TAG, "onStart" )
        super.onStart()
//        checkLoginStatus()
        checkLatestTemp()
    }

    override fun onResume() {
        Log.d(TAG, "onResume" )
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause" )
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop" )
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, " onDestroy" )
        super.onDestroy()
    }

    fun askPermission() {
        Log.d(TAG, "askPermission called")
    }

    fun checkLoginStatus () {
        if (isLoggedIn) {
            Log.d(TAG, "LoggedIn")
        } else Log.d(TAG, "Log Out")
    }

    fun checkLatestTemp() {
        Log.d(TAG, "checkLatestTemp")
    }
}