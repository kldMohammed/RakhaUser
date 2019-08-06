/*
 * Copyright (c) 2019.
 * Created by Khalid Mohammed.
 * Last modified 12/16/18 2:24 PM.
 * All rights reserved.
 */

package com.alhayekgroup.rakhauser.extensions

fun List<Any>?.isNullOrEmpty() = this == null || this.isEmpty()