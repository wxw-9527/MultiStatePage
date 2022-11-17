package com.view.multistatepage

import android.app.Activity
import android.view.View

/**
 * author : Saxxhw
 * email  : xingwangwang@cloudinnov.com
 * time   : 2022/11/17 11:50
 * desc   :
 */

fun View.bindMultiState() = MultiStatePage.bindMultiState(this)

fun Activity.bindMultiState() = MultiStatePage.bindMultiState(this)