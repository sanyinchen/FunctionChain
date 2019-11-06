package com.sanyinchen.block

import com.sanyinchen.block.base.Action

/**
 * Created by sanyinchen on 19-11-6.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-11-6
 */
class FunctionChain(private var interceptors: MutableList<Interceptor> = mutableListOf()) {

    fun addInterceptor(interceptor: Interceptor) {
        if (!interceptors.contains(interceptor)) {
            interceptors.add(interceptor)
        }
    }

    fun dispatch(action: Action) {
        {
            interceptors
                .asReversed()
                .fold({ action: Action -> this.defaultDispatch(action) }, { dispatchFunction, interceptor ->
                    interceptor(dispatchFunction)
                })

        }()(action)
    }

    fun defaultDispatch(action: Action) {
        println("===> default Action")
    }
}