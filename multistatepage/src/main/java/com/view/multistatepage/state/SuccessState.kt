package com.view.multistatepage.state

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.view.multistatepage.MultiState
import com.view.multistatepage.MultiStateContainer

/**
 * author : Saxxhw
 * email  : xingwangwang@cloudinnov.com
 * time   : 2022/11/17 11:53
 * desc   :
 */
class SuccessState : MultiState() {

    override fun onCreateMultiStateView(
        context: Context,
        inflater: LayoutInflater,
        container: MultiStateContainer
    ): View {
        return View(context)
    }

    override fun onMultiStateViewCreate(view: View) = Unit
}