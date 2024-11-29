package com.example.marininasr_01_02

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var namefigure: String
    private lateinit var result: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        result = sharedPreferences.getString("result", "") ?: ""

        val resultTextView: TextView = findViewById(R.id.text2)
        resultTextView.text = result
    }

    fun onStart(view: View) {
        val intent = Intent(this, FirstActivity::class.java)
        startActivity(intent)
    }
}
