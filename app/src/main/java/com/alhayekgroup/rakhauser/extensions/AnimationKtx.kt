/*
 * Copyright (c) 2019.
 * Created by Khalid Mohammed.
 * Last modified 2/8/19 12:46 PM.
 * All rights reserved.
 */

package com.alhayekgroup.rakhauser.extensions

import android.view.animation.Animation

fun Animation.doOnEnd(block: () -> Unit) {
    setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationRepeat(animation: Animation?) {

        }

        override fun onAnimationEnd(animation: Animation?) {
            block()
        }

        override fun onAnimationStart(animation: Animation?) {
        }
    })
}