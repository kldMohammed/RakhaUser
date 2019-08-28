package com.alhayekgroup.rakhauser.ui

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {

    lateinit var gestureScanner: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.alhayekgroup.rakhauser.R.layout.activity_main)

        gestureScanner = GestureDetector(this)

        ObjectAnimator.ofFloat(arrowUp, "translationY", 60f, 10f).apply {
            repeatCount = Animation.INFINITE
            duration = 3000
            start()
        }
        showAllProductsContainer.setOnTouchListener { view, motionEvent ->
            return@setOnTouchListener gestureScanner.onTouchEvent(motionEvent);

        }

    }

    override fun onShowPress(p0: MotionEvent?) {

    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        return true
    }

    override fun onDown(p0: MotionEvent?): Boolean {
        return true
    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {

        Log.i("Test", "On Fling")
        return true
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
      //  toast("swipe up")
        startActivity(Intent(applicationContext , HomeActivity::class.java))
        return true
    }

    override fun onLongPress(p0: MotionEvent?) {
    }
}
