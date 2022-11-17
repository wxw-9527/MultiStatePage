package com.view.multistatepage.state

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import com.view.multistatepage.BaseMultiState
import com.view.multistatepage.databinding.MultiStatePageErrorBinding

/**
 * author : Saxxhw
 * email  : xingwangwang@cloudinnov.com
 * time   : 2022/11/17 10:09
 * desc   :
 */
class ErrorState : BaseMultiState<MultiStatePageErrorBinding>(), OnClickListener {

    override fun onCreateBinding(
        inflater: LayoutInflater, parent: ViewGroup?
    ): MultiStatePageErrorBinding {
        return MultiStatePageErrorBinding.inflate(inflater, parent, false)
    }

    override fun onViewBindingCreated(binding: MultiStatePageErrorBinding) {
        super.onViewBindingCreated(binding)
        binding.root.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        mOnRetryClickListener?.onRetryClick()
    }

    fun setMessage(message: String) {
        mBinding.tvMessage.text = message
    }

    fun setDesc(desc: String) {
        mBinding.tvDesc.text = desc
    }
}