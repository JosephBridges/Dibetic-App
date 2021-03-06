package org.wit.diabeticapp

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import org.wit.diabeticapp.activities.Main

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        //3 Second Splash Time
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, Main::class.java))
            finish()
        },3000)

    }
}