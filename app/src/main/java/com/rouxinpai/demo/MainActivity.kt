package com.rouxinpai.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.core.os.postDelayed
import com.view.multistatepage.MultiStateContainer
import com.view.multistatepage.bindMultiState
import com.view.multistatepage.intf.OnRetryClickListener
import com.view.multistatepage.state.EmptyState
import com.view.multistatepage.state.ErrorState
import com.view.multistatepage.state.LoadingState
import com.view.multistatepage.state.SuccessState

class MainActivity : AppCompatActivity(), OnRetryClickListener {

    private lateinit var mLoadState: MultiStateContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 初始化
        mLoadState = findViewById<TextView>(R.id.tv_content).bindMultiState()
        //
        showLoadingPage()
        Handler(Looper.getMainLooper()).postDelayed(2 * 1000) {
            showLoadingPage(msg = "测试标题", descId = R.string.app_name)
            Handler(Looper.getMainLooper()).postDelayed(2 * 1000) {
                showEmptyPage()
                Handler(Looper.getMainLooper()).postDelayed(2 * 1000) {
                    showEmptyPage(msgId = R.string.app_name)
                    Handler(Looper.getMainLooper()).postDelayed(2 * 1000) {
                        showErrorPage()
                        Handler(Looper.getMainLooper()).postDelayed(2 * 1000) {
                            showErrorPage(msg = "测试异常标题", descId = R.string.app_name)
                            Handler(Looper.getMainLooper()).postDelayed(2 * 1000) {
                                showSuccessPage()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onRetryClick() {

    }

    private fun showLoadingPage(
        msgId: Int? = null,
        msg: String? = null,
        descId: Int? = null,
        desc: String? = null
    ) {
        val loadState = mLoadState
        if (loadState.currentState is SuccessState) return
        val loadingMsg = when {
            msgId != null -> getString(msgId)
            msg != null -> msg
            else -> null
        }
        val loadingDesc = when {
            descId != null -> getString(descId)
            desc != null -> desc
            else -> null
        }
        loadState.show<LoadingState>(false) { state ->
            if (loadingMsg != null) {
                state.setMessage(loadingMsg)
            }
            if (loadingDesc != null) {
                state.setDesc(loadingDesc)
            }
        }
    }

    private fun showEmptyPage(msgId: Int? = null, msg: String? = null) {
        val loadState = mLoadState
        val emptyMsg = when {
            msgId != null -> getString(msgId)
            msg != null -> msg
            else -> null
        }
        loadState.show<EmptyState>(false) { state ->
            if (emptyMsg != null) {
                state.setMessage(emptyMsg)
            }
            state.setOnRetryClickListener(this)
        }
    }

    private fun showErrorPage(
        msgId: Int? = null,
        msg: String? = null,
        descId: Int? = null,
        desc: String? = null
    ) {
        val loadState = mLoadState
        val errorMsg = when {
            msgId != null -> getString(msgId)
            msg != null -> msg
            else -> null
        }
        val errorDesc = when {
            descId != null -> getString(descId)
            desc != null -> desc
            else -> null
        }
        loadState.show<ErrorState>(false) { state ->
            if (errorMsg != null) {
                state.setMessage(errorMsg)
            }
            if (errorDesc != null) {
                state.setDesc(errorDesc)
            }
            state.setOnRetryClickListener(this)
        }
    }

    private fun showSuccessPage() {
        val loadState = mLoadState
        if (loadState.currentState is SuccessState) return
        mLoadState.show<SuccessState>()
    }
}