package com.example.foregroundservice

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foregroundservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickListener()
    }

    private fun clickListener() {
        binding.play.setOnClickListener {
            val serviceIntent = Intent(this, MusicPlayerService::class.java)
            serviceIntent.action = Constants.ACTION.STARTFOREGROUND_ACTION
            startService(serviceIntent)
        }

        binding.pause.setOnClickListener {
            val serviceIntent = Intent(this, MusicPlayerService::class.java)
            serviceIntent.action = Constants.ACTION.STOPFOREGROUND_ACTION
            startService(serviceIntent)
        }
    }
}