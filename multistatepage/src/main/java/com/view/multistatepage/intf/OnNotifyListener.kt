package com.view.multistatepage.intf

import com.view.multistatepage.MultiState

/**
 * author : Saxxhw
 * email  : xingwangwang@cloudinnov.com
 * time   : 2022/11/17 11:49
 * desc   :
 */
fun interface OnNotifyListener<T : MultiState> {
    fun onNotify(multiState: T)
}