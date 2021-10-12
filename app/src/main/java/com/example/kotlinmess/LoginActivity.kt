package com.example.kotlinmess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }


    fun registerNow(view: View?) {
        val intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)
    }
}