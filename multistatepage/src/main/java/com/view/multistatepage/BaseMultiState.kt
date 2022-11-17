package com.view.multistatepage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.view.multistatepage.intf.OnRetryClickListener

/**
 * author : Saxxhw
 * email  : xingwangwang@cloudinnov.com
 * time   : 2022/11/17 9:58
 * desc   :
 */
abstract class BaseMultiState<VB : ViewBinding> : MultiState() {

    protected lateinit var mBinding: VB

    protected var mOnRetryClickListener: OnRetryClickListener? = null

    override fun onCreateMultiStateView(
        context: Context, inflater: LayoutInflater, container: MultiStateContainer
    ): View {
        mBinding = onCreateBinding(inflater, container)
        return mBinding.root
    }

    override fun onMultiStateViewCreate(view: View) {
        onViewBindingCreated(mBinding)
    }

    protected abstract fun onCreateBinding(inflater: LayoutInflater, parent: ViewGroup?): VB

    protected open fun onViewBindingCreated(binding: VB) = Unit

    fun setOnRetryClickListener(listener: OnRetryClickListener?) {
        mOnRetryClickListener = listener
    }
}