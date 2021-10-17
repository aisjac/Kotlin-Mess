package com.example.kotlinmess

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.core.graphics.ColorUtils
import androidx.core.graphics.toColorInt
import com.example.kotlinmess.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private lateinit var email:String
    private  lateinit var pass :String
    private lateinit var aisjac : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginBinding: ActivityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)


        loginBinding.loginBtnId.setOnClickListener {
            logIn()
        }

    }



    private fun logIn() {
        val  validateEmail : Boolean = true
        val  validatePassword : Boolean = true
        if (!validateEmail or !validatePassword) {
            Toast.makeText(this@LoginActivity, "Validation Unsuccessful !", Toast.LENGTH_SHORT)
                .show()
        } else {

            otpVerification()
        }
    }


    fun registerNow(view: View?) {
        val intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)
    }


//    private fun validateEmail(): Boolean {
//        return if (email.isEmpty()) {
//            aisjac. = "Type your valid email"
//            false
//        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()) {
//            password!!.error = "Invalid Email!"
//            //            emailTextInputLayout.setBackgroundColor(Color.parseColor("#bdbdbd"));
//            false
//        } else {
//            email!!.error = null
//            true
//        }
//    }
//
//    private fun validatePassword(): Boolean {
//
//        return if (password!!.text.isEmpty()) {
//            password!!.error = "Type your password"
//            false
//        } else {
//            password!!.error = null
//            true
//        }
//    }


    private fun otpVerification() {
        startActivity(Intent(this@LoginActivity, OtpVerificationActivity::class.java))
        finish()
    }


}