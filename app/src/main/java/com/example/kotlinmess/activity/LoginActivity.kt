package com.example.kotlinmess.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.kotlinmess.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE)
        loginPreferences.edit()

        val saveLogin = loginPreferences.getBoolean("saveLogin", false)
        if (saveLogin) {
            binding.logEmailEtId.setText(loginPreferences.getString("username", ""))
            binding.logPassEtId.setText(loginPreferences.getString("password", ""))
            binding.checkBox.isChecked = true
        }

        binding.loginBtnId.setOnClickListener {
            logIn()
        }

        binding.regiNowButtonId.setOnClickListener {
            registerNow()
        }


    }



    private fun logIn() {
        if (!validateEmail() or !validatePassword()) {
            Toast.makeText(this@LoginActivity, "Validation Unsuccessful !", Toast.LENGTH_SHORT)
                .show()
        } else {
            Toast.makeText(this, "Otp Verification", Toast.LENGTH_SHORT).show()
            otpVerification()
        }
    }


    private fun registerNow() {
        val intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)
    }


    private fun otpVerification() {
        val intent = Intent(this, VerificationActivity::class.java)
        startActivity(intent)
    }

    private fun validateEmail(): Boolean {
        val userEmail: String = binding.logEmailEtId.text.toString().trim()
        return if (userEmail.isEmpty()) {
            binding.logEmailEtId.error = "Type your valid email"
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            binding.logEmailEtId.error = "Invalid Email!"
            false
        } else {
            binding.logEmailEtId.error = null
            true
        }
    }

    private fun validatePassword(): Boolean {
        val password: String = binding.logPassEtId.text.toString().trim()
        return if (password.isEmpty()) {
            binding.logPassEtId.error = "Type your password"
            false
        } else {
            binding.logPassEtId.error = null
            true
        }
    }

}