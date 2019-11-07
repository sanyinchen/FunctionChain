package com.sanyinchen.block

import com.sanyinchen.block.base.Action

/**
 * Created by sanyinchen on 19-11-6.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-11-6
 */
class FunctionChain(
    private val interceptors: MutableList<Interceptor> = mutableListOf(),
    private val initDispatch: DispatchFunction
) {

    fun addInterceptor(interceptor: Interceptor) {
        if (!interceptors.contains(interceptor)) {
            interceptors.add(interceptor)
        }
    }

    fun dispatch(action: Action) {
        {
            interceptors
                .asReversed()
                .fold({ action: Action -> this.initDispatch(action) }, { dispatchFunction, interceptor ->
                    interceptor(dispatchFunction)
                })

        }()(action)
    }

}