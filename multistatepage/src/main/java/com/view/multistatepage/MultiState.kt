package com.view.multistatepage

import android.content.Context
import android.view.LayoutInflater
import android.view.View

/**
 * author : Saxxhw
 * email  : xingwangwang@cloudinnov.com
 * time   : 2022/11/17 11:51
 * desc   :
 */
abstract class MultiState {

    /**
     * 创建stateView
     */
    abstract fun onCreateMultiStateView(
        context: Context,
        inflater: LayoutInflater,
        container: MultiStateContainer
    ): View

    /**
     * stateView创建完成
     */
    abstract fun onMultiStateViewCreate(view: View)
}