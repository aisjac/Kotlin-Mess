package com.example.kotlinmess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
//        this.supportActionBar?.hide()

        val timer: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(4000)
                    val intent = Intent(this@SplashScreen, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    super.run()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        timer.start()
    }
}