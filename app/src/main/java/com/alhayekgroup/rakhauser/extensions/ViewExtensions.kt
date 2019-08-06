/*
 * Copyright (c) 2019.
 * Created by Khalid Mohammed.
 * Last modified 3/18/19 2:24 PM.
 * All rights reserved.
 */

package com.alhayekgroup.rakhauser.extensions

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.FragmentActivity
import com.alhayekgroup.rakhauser.R
import com.google.android.material.snackbar.Snackbar


fun ViewGroup.inflate(layoutRes: Int, attachToRoot: Boolean = false): View? {
    return LayoutInflater.from(context)
            .inflate(layoutRes, this, attachToRoot)
}

fun FragmentActivity.debug(message: String, customTag: String = "") {
    Log.d(this.javaClass.simpleName, "$customTag : $message")
}


private fun <T> unsaveLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)

fun <T : View> FragmentActivity.bind(@IdRes idRes: Int): Lazy<T> {
    return unsaveLazy { findViewById<T>(idRes) }
}


fun <T : View> View.bind(@IdRes idRes: Int): Lazy<T> {
    return unsaveLazy { findViewById<T>(idRes) }
}


fun Context.toast(message: String) {

    Toast.makeText(this, message, Toast.LENGTH_LONG)
            .show()

}


fun Context.toast(message: Int) {
    Toast.makeText(this, message, Toast.LENGTH_LONG)
            .show()
}


fun View.longSnackbar(message: CharSequence) = Snackbar
        .make(this, message, Snackbar.LENGTH_LONG)
        .apply { show() }


fun View.errorSnackBar(message: Int) = Snackbar
        .make(this, message, Snackbar.LENGTH_LONG)
        .apply {

            //generate the snackbar
            //  val sb = Snackbar.make(rootView, snack.text, duration)
//set te action button text color
            setActionTextColor(context.resources.getColor(R.color.white))
//Get the view of the snackbar
            // val sbView = view
//set background color
            view.setBackgroundColor(context.resources.getColor(R.color.red))
//Get the textview of the snackbar text

            val textView = view.findViewById(R.id.snackbar_text) as TextView
//set text color
            textView.setTextColor(context.resources.getColor(R.color.white))
//increase max lines of text in snackbar. default is 2.
            textView.maxLines = 10
            show()
        }


//private fun showSnackbar(coordinatorLayout: CoordinatorLayout, duration: Int): Snackbar { // Create the Snackbar
//    val snackbar = Snackbar.make(coordinatorLayout, "", duration)
//    // 15 is margin origin all the sides for snackbar
//    val marginFromSides = 15
//
//    val height = 100f
//
//    //inflate view
//    val snackView = layoutInflater().inflate(R.layout.snackbar_layout, null)
//
//    // White background
//    snackbar.view.setBackgroundColor(Color.WHITE)
//    // for rounded edges
//    snackbar.view.background = getResources().getDrawable(R.drawable.round_edges)
//
//    val snackBarView = snackbar.view as Snackbar.SnackbarLayout
//    val parentParams = snackBarView.layoutParams as FrameLayout.LayoutParams
//    parentParams.setMargins(marginFromSides, 0, marginFromSides, marginFromSides)
//    parentParams.height = height.toInt()
//    parentParams.width = FrameLayout.LayoutParams.MATCH_PARENT
//    snackBarView.layoutParams = parentParams
//
//    snackBarView.addView(snackView, 0)
//    return snackbar
//}

fun View.longSnackbar(message: Int) = Snackbar
        .make(this, message, Snackbar.LENGTH_LONG)
        .apply { show() }


inline fun View.longSnackbar(@StringRes message: Int, @StringRes actionText: Int, noinline action: (View) -> Unit): Snackbar {
    return Snackbar
            .make(this, message, Snackbar.LENGTH_LONG)
            .setAction(actionText, action)
            .apply { show() }
}


fun View.slideExit() {
    if (translationY == 0f) animate().translationY(-height.toFloat())
}

fun View.slideEnter() {
    if (translationY < 0f) animate().translationY(0f)
}

fun View.show() {
    visibility = View.VISIBLE
}


fun View.gone() {
    if (isVisible) {
        visibility = View.GONE
    }
}

var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)


//fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)

fun ImageView.color(res: Int) = with(context) {
    setBackgroundColor(res)
}

//inline fun supportsLollipop(code: () -> Unit) {
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//        code()
//    }
//}
//
//inline fun supportsKitkat(code: () -> Unit) {
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//        code()
//    }
//}

fun EditText.afterChanged(cb: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            cb(s.toString())
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    })
}

//
//fun EditText.validate(validator: (String) -> Boolean, message: String): String {
//    afterChanged {
//        error = if (validator(it)) null else message
//    }
//    error = if (validator(text.toString())) null else message
//
//    return text.toString()
//}
//
//fun TextInputEditText.validate(validator: (String) -> Boolean, message: String,
//                               textInputLayout: TextInputLayout): String {
//    afterChanged {
//        textInputLayout.error = if (validator(it)) null else message
//    }
//    textInputLayout.error = if (validator(text.toString())) null else message
//
//    return text.toString()
//}
//
//
//fun TextInputLayout.validate(validator: (String) -> Boolean, message: String): String {
//    this.editText?.afterChanged {
//        this.error = if (validator(it)) null else message
//    }
//    this.error = if (validator(editText?.text.toString())) null else message
//
//    return editText?.text.toString()
//}


fun View.hide() {
    visibility = View.INVISIBLE
}

val View.isVisible: Boolean
    get() = this.visibility == View.VISIBLE


fun View.enable() {
    isEnabled = true
}

fun View.disable() {
    isEnabled = false
}

//edit text
fun EditText.clear() {
    setText("")
}


// fun ImageView.loadImage(imgUrl: String) = Picasso.with(context).load(imgUrl).into(this)

//fun ImageView.loadImage(imgUrl: String) = Glide.with(this).load(imgUrl)
//    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//    .into(this)


fun EditText.asString(): String {
    try {
        return text.toString().trim()
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return ""
}


/*
fun ViewGroup.formIsValid(): Boolean {
    var bool = false
    for (i in 0 until childCount) {
        val v = getChildAt(i)
        if (v is TextInputEditText) {
            //validate your EditText here
            bool = v.error.isNotEmpty() && v.text.toString() != ""
        }
    }

    return bool
}


fun SwipeRefreshLayout.onRefresh(onRefresh: () -> Unit) {
    setOnRefreshListener {
        onRefresh()
        isRefreshing = false
    }

}*/

fun View.hideKeybord() {
    if (requestFocus()) {
        val imm = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(this, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }
}



