package com.example.flavory.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.flavory.R
import com.example.flavory.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG: String? = MainActivity::class.java.canonicalName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.homeFragment)
                    true
                }

                R.id.recipes -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.recipesFragment)
                    true
                }

                R.id.profile -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.profileFragment)
                    true
                }

                R.id.search -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.searchFragment)
                    true
                }

                else -> false
            }

        }

        Log.d(TAG, "onCreate: MainActivity created.")

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: MainActivity started.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: MainActivity resumed.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: MainActivity paused.")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: MainActivity stopped.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: MainActivity destroyed.")
    }
}