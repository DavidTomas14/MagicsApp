package com.company.mobile.android.appname.app.splash

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.company.mobile.android.appname.app.common.navigation.Navigator

class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler().postDelayed({
            Navigator.navigateToMainActivity(this)
            finish()
        },1000)
    }
}