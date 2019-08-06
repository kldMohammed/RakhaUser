/*
 * Copyright (c) 2019.
 * Created by Khalid Mohammed.
 * Last modified 3/1/19 9:52 AM.
 * All rights reserved.
 */

package com.alhayekgroup.rakhauser.extensions

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import java.util.*


inline fun <reified T : Activity, W : ArrayList<W>> Context.startActivity(
    vararg params: Pair<String, W>
) {
    val intent = Intent(this, T::class.java)
    params.forEach { intent.putExtra(it.first, it.second) }
    startActivity(intent)
}


fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)


fun Context.progressDialog(message: String): ProgressDialog {
    val progressDialog = ProgressDialog(this)
    progressDialog.setMessage(message)
    return progressDialog
}


inline fun <reified T : Any> Activity.extra(key: String, default: T? = null) = lazy {
    val value = intent?.extras?.get(key)
    if (value is T) value else default
}

inline fun <reified T : Any> Activity.extraNotNull(key: String, default: T? = null) = lazy {
    val value = intent?.extras?.get(key)
    requireNotNull(if (value is T) value else default) { key }
}


inline fun <reified T : Any> Fragment.extra(key: String, default: T? = null) = lazy {
    val value = arguments?.get(key)
    if (value is T) value else default
}

inline fun <reified T : Any> Fragment.extraNotNull(key: String, default: T? = null) = lazy {
    val value = arguments?.get(key)
    requireNotNull(if (value is T) value else default) { key }
}



fun Context.changeLanguageAndDirection(localeStr: String) {

    val locale = Locale(localeStr)//getLocale();
    val config = resources.configuration
    
    config.locale = locale
    if (Build.VERSION.SDK_INT >= 17) {
        config.setLocale(locale)
        config.setLayoutDirection(locale)
    }
    resources.updateConfiguration(config, resources.displayMetrics)

}
