package wael.emy.notebook.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import wael.emy.notebook.R

class SplashActivity : AppCompatActivity() {

    private val delayMillis:Long = 1200
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(applicationContext, HomeActivity::class.java))
            finish()
        }, delayMillis)
    }
}
