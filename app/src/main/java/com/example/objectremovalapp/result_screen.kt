package com.example.objectremovalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class result_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_screen)


        findViewById<Button>(R.id.backbutton)
            .setOnClickListener {
                val intent= Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
    }
}