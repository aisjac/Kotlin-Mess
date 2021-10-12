package com.example.kotlinmess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

    }

    fun backToLogin(view: android.view.View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}