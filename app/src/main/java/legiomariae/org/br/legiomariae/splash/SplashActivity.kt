package legiomariae.org.br.legiomariae.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import legiomariae.org.br.legiomariae.meeting.NavigationActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this@SplashActivity, NavigationActivity::class.java))
        finish()
    }

    override fun onRestart() {
        super.onRestart()
        startActivity(Intent(this@SplashActivity, NavigationActivity::class.java))
        finish()
    }
}
