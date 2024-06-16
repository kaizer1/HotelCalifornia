package com.artem.mitrofanov.middle.hotelcalifornia

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val share = applicationContext.getSharedPreferences("main", Context.MODE_PRIVATE)

        val buttonStart = findViewById<Button>(R.id.statrhgj).setOnClickListener {
            val inten  =  Intent(this, See_allTour::class.java)
            startActivity(inten)
        }

    }
}