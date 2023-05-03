package com.example.paintapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.TextView

class SplashScreenAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val text: TextView = findViewById(R.id.tvmove)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.startanim)
        text.startAnimation(slideAnimation)
        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this@SplashScreenAct, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 2500)
    }

}