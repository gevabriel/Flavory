package com.example.flavory.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import com.example.flavory.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {
    companion object {
        private val TAG: String? = SplashActivity::class.java.canonicalName
    }

    val SPLASH_TIME_OUT = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: SplashActivity created.")
        val handlerThread = HandlerThread("SplashHandlerThread", -10)
        handlerThread.start()
        val handler = Handler(handlerThread.looper)
        handler.postDelayed(
            {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            },
            SPLASH_TIME_OUT.toLong()
        )

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: SplashActivity started.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: SplashActivity resumed.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: SplashActivity paused.")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: SplashActivity stopped.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: SplashActivity destroyed.")
    }
}