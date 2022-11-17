package com.view.multistatepage

/**
 * author : Saxxhw
 * email  : xingwangwang@cloudinnov.com
 * time   : 2022/11/17 12:43
 * desc   :
 */
data class MultiStateConfig(var alphaDuration: Long = 500) {

    class Builder {

        private var alphaDuration: Long = 500

        fun alphaDuration(duration: Long): Builder {
            this.alphaDuration = duration
            return this
        }

        fun build() = MultiStateConfig(alphaDuration = alphaDuration)
    }
}