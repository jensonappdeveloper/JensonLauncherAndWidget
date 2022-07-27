package com.example.mylauncher.ui

import android.content.Intent
import android.os.BatteryManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mylauncher.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

        binding.button.setOnClickListener {
            val intent = Intent(applicationContext, AppsListActivity::class.java)
            startActivity(intent)
        }

        binding.layout.setOnLongClickListener {
            //getwidget()
            true
        }

    }


    private fun initview() {
        val bm = applicationContext.getSystemService(BATTERY_SERVICE) as BatteryManager
        val batLevel: Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        binding.batteryPercentage.setText("$batLevel%")
    }

    override fun onBackPressed() {
        //super.onBackPressed()
    }




}