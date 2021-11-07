package com.example.kotlinmess.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlinmess.R
import com.example.kotlinmess.databinding.ActivityVerificationBinding

class VerificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVerificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }


    }




    fun backToLoginFromVerification(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

    }
}