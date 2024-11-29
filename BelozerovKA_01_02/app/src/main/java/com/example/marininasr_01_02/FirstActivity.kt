package com.example.marininasr_01_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
    }
    fun nextekr(view: View) {
        val intent = Intent(this, RegisterScreen::class.java)
        startActivity(intent)
    }
}