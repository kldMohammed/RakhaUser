

/*
 * Copyright (c) 2019.
 * Created by Khalid Mohammed.
 * Last modified 12/19/18 10:36 PM.
 * All rights reserved.
 */

package com.alhayekgroup.rakhauser.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alhayekgroup.rakhauser.R
import java.net.SocketTimeoutException
import java.text.DateFormat
import java.util.*

fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}

inline fun Context.doOnConnected(msg: Int = 0, onConnected: () -> Unit) {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netInfo = cm.activeNetworkInfo
    return if (netInfo != null && netInfo.isConnectedOrConnecting) {
        try {
            onConnected()
        } catch (e: Exception) {
            when (e) {
                is SocketTimeoutException -> {
                    toast(getString(R.string.connection_problem))
                }
            }
            e.printStackTrace()
        }
    } else {
        if (msg == 0) {
        } else {
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }
    }
}


inline fun Fragment.doOnConnected(msg: Int = 0, onConnected: () -> Unit) {
    val cm = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netInfo = cm.activeNetworkInfo
    return if (netInfo != null && netInfo.isConnectedOrConnecting) {
        try {
            onConnected()
        } catch (e: Exception) {
            when (e) {
                is SocketTimeoutException -> {
                    context?.toast(getString(R.string.connection_problem))
                }
            }
            e.printStackTrace()

        }
    } else {
        if (msg == 0) {
        } else {
            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
        }
    }
}


fun round(value: Double, places: Int): Double {
    var value = value
    if (places < 0) throw IllegalArgumentException()

    val factor = Math.pow(10.0, places.toDouble()).toLong()
    value *= factor
    val tmp = Math.round(value)
    return tmp.toDouble() / factor
}


fun justTry(block: () -> Unit) {
    try {
        block()
    } catch (t: Throwable) {
        t.printStackTrace()
    }
}
