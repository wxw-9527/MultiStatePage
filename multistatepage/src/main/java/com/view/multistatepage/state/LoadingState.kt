package com.view.multistatepage.state

import android.view.LayoutInflater
import android.view.ViewGroup
import com.view.multistatepage.BaseMultiState
import com.view.multistatepage.databinding.MultiStatePageLoadingBinding

/**
 * author : Saxxhw
 * email  : xingwangwang@cloudinnov.com
 * time   : 2022/11/17 10:02
 * desc   :
 */
class LoadingState : BaseMultiState<MultiStatePageLoadingBinding>() {

    override fun onCreateBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): MultiStatePageLoadingBinding {
        return MultiStatePageLoadingBinding.inflate(inflater, parent, false)
    }

    fun setMessage(message: String) {
        mBinding.tvMessage.text = message
    }

    fun setDesc(desc: String) {
        mBinding.tvDesc.text = desc
    }
}