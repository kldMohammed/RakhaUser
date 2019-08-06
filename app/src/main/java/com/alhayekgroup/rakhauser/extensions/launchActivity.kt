package com.alhayekgroup.rakhauser.extensions

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
@JvmOverloads
inline fun <reified T : Any> Activity.launchActivity(
        requestCode: Int = -1,
    // options: Bundle? = null

        noinline init: Intent.() -> Unit = {}) {


    val intent = newIntent<T>(this)
    intent.init()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        val options: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this)
        startActivityForResult(intent, requestCode, options.toBundle())
    } else {
        startActivityForResult(intent, requestCode)
    }
}

inline fun <reified T : Any> Context.launchActivity(
    //  options: Bundle? = null,
        noinline init: Intent.() -> Unit = {}) {

    val intent = newIntent<T>(this)
    intent.init()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        val options: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation((applicationContext as Activity?))

        startActivity(intent, options.toBundle())
    } else {
        startActivity(intent)
    }
}

inline fun <reified T : Any> newIntent(context: Context): Intent =
    Intent(context, T::class.java)


inline fun < reified T : Any> Context.newIntent() {
    startActivity(Intent(this,T::class.java ))
}

