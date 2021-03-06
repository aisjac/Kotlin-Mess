package com.example.kotlinmess.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.example.kotlinmess.adapter.Pager_Adapter
import com.example.kotlinmess.fragment.Fragment_One
import com.example.kotlinmess.fragment.Fragment_Three
import com.example.kotlinmess.fragment.Fragment_Two
import com.example.kotlinmess.R


class MainActivity : AppCompatActivity() {

    private lateinit var pagerview_adapter: Pager_Adapter
    private lateinit var my_viewpaper: ViewPager
    private lateinit var first_indicator: ImageView
    private lateinit var second_indicator: ImageView
    private lateinit var third_indicator: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_viewpaper = findViewById(R.id.my_viewpaper)
        first_indicator = findViewById(R.id.first_indicator)
        second_indicator = findViewById(R.id.second_indicator)
        third_indicator = findViewById(R.id.third_indicator)

        pagerview_adapter = Pager_Adapter(supportFragmentManager)
        add_MyFragment()
        my_viewpaper.adapter = pagerview_adapter
        my_viewpaper.addOnPageChangeListener(MyListener(this::onPageSelected))


    }

    @SuppressLint("SetTextI18n")
    private fun onPageSelected(position: Int) {
        when (position) {
            0 -> {
                first_indicator.setImageResource(R.drawable.active_circle)
                second_indicator.setImageResource(R.drawable.disable_circle)
                third_indicator.setImageResource(R.drawable.disable_circle)

            }
            1 -> {
                first_indicator.setImageResource(R.drawable.disable_circle)
                second_indicator.setImageResource(R.drawable.active_circle)
                third_indicator.setImageResource(R.drawable.disable_circle)

            }
            2 -> {
                first_indicator.setImageResource(R.drawable.disable_circle)
                second_indicator.setImageResource(R.drawable.disable_circle)
                third_indicator.setImageResource(R.drawable.active_circle)
            }
        }
    }


    private fun add_MyFragment() {
        pagerview_adapter.addFragment(Fragment_One())
        pagerview_adapter.addFragment(Fragment_Two())
        pagerview_adapter.addFragment(Fragment_Three())
    }

    class MyListener(private val closure: (Int) -> Unit) : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(p0: Int) {

        }

        override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

        }

        override fun onPageSelected(position: Int) = closure(position)
    }


    fun continueWithEmail(view: android.view.View) {
        val intent = Intent(this, LoginActivity::class.java )
        startActivity(intent)
    }

}