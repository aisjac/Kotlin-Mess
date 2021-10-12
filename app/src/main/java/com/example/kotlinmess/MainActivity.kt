package com.example.kotlinmess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class MainActivity : AppCompatActivity() {
    var carouselView: CarouselView? = null

    var sampleImages = intArrayOf(
        R.drawable.grp1,
        R.drawable.grp2,
        R.drawable.grp3
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        carouselView = findViewById<View>(R.id.carouselView) as CarouselView
        carouselView!!.setPageCount(sampleImages.size)
        carouselView!!.setImageListener(imageListener)
    }

    var imageListener: ImageListener = ImageListener { position, imageView ->
        imageView.setImageResource(sampleImages[position])
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER
    }


    fun continueWithEmail(view: android.view.View) {
        val intent = Intent(this,LoginActivity::class.java )
        startActivity(intent)
    }

}