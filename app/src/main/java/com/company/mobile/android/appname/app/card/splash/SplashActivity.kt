package com.company.mobile.android.appname.app.card.splash

import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.company.mobile.android.appname.app.R
import com.company.mobile.android.appname.app.common.navigation.Navigator

class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler().postDelayed({
            Navigator.navigateToMainActivity(this)
        },1000
        )
    }


}