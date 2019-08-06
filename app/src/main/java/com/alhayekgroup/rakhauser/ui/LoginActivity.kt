package com.alhayekgroup.rakhauser.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alhayekgroup.rakhauser.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var isShowed = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        loginSignInBtn.setOnClickListener {
            /* loginSignInBtn.showProgress {
                 progressColor = Color.WHITE
                 gravity = DrawableButton.GRAVITY_CENTER
             }

             loginSignInBtn.isEnabled = false
             Handler().postDelayed({
                 loginSignInBtn.isEnabled = true
                 loginSignInBtn.hideProgress()
             }, 3000)*/
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }


        loginCreateAccountBtn.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterActivity::class.java))
        }

        loginForgotPassword.setOnClickListener {
            startActivity(Intent(applicationContext, ForgotPasswordActivity::class.java))
        }
    }
}
