package com.view.multistatepage.state

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import com.view.multistatepage.BaseMultiState
import com.view.multistatepage.databinding.MultiStatePageEmptyBinding

/**
 * author : Saxxhw
 * email  : xingwangwang@cloudinnov.com
 * time   : 2022/11/17 10:05
 * desc   :
 */
class EmptyState : BaseMultiState<MultiStatePageEmptyBinding>(), OnClickListener {

    override fun onCreateBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): MultiStatePageEmptyBinding {
        return MultiStatePageEmptyBinding.inflate(inflater, parent, false)
    }

    override fun onViewBindingCreated(binding: MultiStatePageEmptyBinding) {
        super.onViewBindingCreated(binding)
        binding.root.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        mOnRetryClickListener?.onRetryClick()
    }

    fun setMessage(message: String) {
        mBinding.tvMessage.text = message
    }
}