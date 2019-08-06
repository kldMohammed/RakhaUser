/*
 * Copyright (c) 2019.
 * Created by Khalid Mohammed.
 * Last modified 3/21/19 1:02 PM.
 * All rights reserved.
 */

package com.alhayekgroup.rakhauser.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

val Fragment.activityCtx
    get() = activity!!

val Fragment.appContext
    get() = activity?.applicationContext

/**
 * @param layoutId the layout id destination replace fragment with
 * @param fragment the fragment destination open
 *
 * This function is destination open a fragment
 * */
/*fun FragmentActivity.transaction(layoutId: Int, fragment: Fragment, addToBackStack: Boolean = false,
                                  backStackName: String = "") {
//    this?.supportFragmentManager?.beginTransaction()
//        ?.replace(layoutId, fragment)?.commit()

   // playSound(R.raw.navigation_transition)
    val manager =supportFragmentManager
    
    
    val transaction = manager.beginTransaction()
    if (addToBackStack) {
        if (backStackName.isNotEmpty()) {
            transaction.addToBackStack(backStackName)
            //  manager?.popBackStack(backStackName, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            
        } else {
            //   manager?.popBackStack(backStackName, FragmentManager.POP_BACK_STACK_INCLUSIVE)

            transaction.addToBackStack(null)
        }
    }
    transaction.setCustomAnimations(
        R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left,
        R.anim.slide_out_right)
        .replace(layoutId, fragment)
        .commit()
}*/

/*
fun Fragment.transaction(layoutId: Int, fragment: Fragment, addToBackStack: Boolean = false,
                         backStackName: String = "") {
    //    this?.activity?.supportFragmentManager?.beginTransaction()
    //        ?.setCustomAnimations(R.anim.enter, R.anim.slide_out_left, R.anim.exit,
    //            R.anim.slide_out_right)
    //        ?.replace(layoutId, fragment)?.commit()
    playSound(R.raw.navigation_transition)

    val manager = this.activity?.supportFragmentManager


    val transaction = manager?.beginTransaction()
    if (addToBackStack) {
        if (backStackName.isNotEmpty()) {
            transaction?.addToBackStack(backStackName)
          //  manager?.popBackStack(backStackName, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        } else {
         //   manager?.popBackStack(backStackName, FragmentManager.POP_BACK_STACK_INCLUSIVE)

            transaction?.addToBackStack(null)
        }
    }
    transaction?.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left,
        R.anim.slide_out_right)
        ?.replace(layoutId, fragment)
        ?.commit()
}

*/

fun Fragment.toast(message: String) {
    Toast.makeText(activity, message, Toast.LENGTH_LONG)
        .show()
}

fun Fragment.toast(messageId: Int) {
    Toast.makeText(activity, messageId, Toast.LENGTH_LONG)
        .show()
}