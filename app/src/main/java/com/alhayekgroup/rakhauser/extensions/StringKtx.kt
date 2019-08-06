package com.alhayekgroup.rakhauser.extensions

import android.util.Patterns

fun String.isValidPhone(): Boolean = this.isNotEmpty() && Patterns.PHONE.matcher(this).matches()

fun String.isPhone(): Boolean = this.length == 12


fun String.isValidEmail(): Boolean = this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.isValidPassword(): Boolean = this.length >= 6

/*fun String.isValidPassword(): Boolean = this.matches(kotlin.text
        .Regex("""^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&=+*])(?=\S+$).{8,}$"""))*/

fun String.isValidLength(): Boolean = this.length >= 2


fun String.isMatch(pwd: String): Boolean = this == pwd