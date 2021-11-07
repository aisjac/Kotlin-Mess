package com.example.kotlinmess.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.kotlinmess.databinding.ActivityRegistrationBinding
import java.util.regex.Pattern

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    private val PASSWORD_PATTERN = Pattern.compile(
        "^" +
                "(?=.*[@#$%^&+=])" +  // at least 1 special character
                "(?=\\S+$)" +  // no white spaces
                "(?=.*[a-z])" +  // at least one lowercase
                ".{4,}" +  // at least 4 characters
                "$"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.regButtonId.setOnClickListener {

            if (!validateFullName() or !validateEmail() or !validatePhoneNumber() or !validatePassword() or !confPassValidation()) {
                Toast.makeText(this, "Validation Unsuccessful !", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Validation Successful!", Toast.LENGTH_SHORT).show()

            }


        }
    }


    private fun validateFullName(): Boolean {
        val name: String = binding.regNameEtId.text.toString()
        return if (name.isEmpty()) {
            //            NameET.requestFocus();
            binding.regNameEtId.setError("Field can not be empty")
            false
        } else {
            binding.regNameEtId.setError(null)
            true
        }
    }

    private fun validateEmail(): Boolean {
        val email: String = binding.regEmailEtId.getText().toString()
        val checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return if (email.isEmpty()) {
            binding.regEmailEtId.setError("Field can not be empty")
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.regEmailEtId.setError("Invalid Email!")
            false
        } else {
            binding.regEmailEtId.setError(null)
            true
        }
    }

    private fun validatePhoneNumber(): Boolean {
        val phone: String = binding.regPhoneEtId.getText().toString()
        //        String checkspaces = "^[0-9]{10,13}$";
        return if (phone.isEmpty()) {
            binding.regPhoneEtId.setError("Enter valid phone number")
            false
        } else if (phone.length < 11 || phone.length > 13) {
            binding.regPhoneEtId.setError("Invalid phone number!")
            false
        } else {
            binding.regPhoneEtId.setError(null)
            true
        }
    }

    private fun validatePassword(): Boolean {
        val pass: String = binding.regPassEtId.getText().toString()
        //        String checkPassword = "^" +
//                "(?=.*[0-9])" +         //at least 1 digit
//                "(?=.*[a-z])" +         //at least 1 lower case letter
//                "(?=.*[A-Z])" +         //at least 1 upper case letter
//                "(?=.*[a-zA-Z])" +      //any letter
//                "(?=.*[@#$%^&+=])" +    //at least 1 special character
//                "(?=S+$)" +             //no white spaces
//                ".{4,}" +               //at least 4 characters
//                "$";
        return if (pass.isEmpty()) {
            binding.regPassEtId.setError("Field can not be empty")
            false
        } else if (!PASSWORD_PATTERN.matcher(pass).matches()) {
            binding.regPassEtId.setError("At least one lowercase,Uppercase,number and special character needed")
            false
        } else {
            binding.regPassEtId.setError(null)
            true
        }
    }

    private fun confPassValidation(): Boolean {
        val pass: String = binding.regConfPassEtId.getText().toString()
        val confPass: String = binding.regConfPassEtId.getText().toString()
        return if (confPass.isEmpty()) {
            binding.regConfPassEtId.setError("Field can not be empty")
            false
        } else if (confPass != pass) {
            binding.regConfPassEtId.setError("Password didn't match!")
            false
        } else {
            binding.regConfPassEtId.setError(null)
            true
        }
    }


    fun backToLogin(view: android.view.View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}

