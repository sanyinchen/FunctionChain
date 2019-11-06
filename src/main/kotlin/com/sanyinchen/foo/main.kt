package com.sanyinchen.foo

import com.sanyinchen.block.FunctionChain
import com.sanyinchen.block.base.Action

/**
 * Created by sanyinchen on 19-11-6.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-11-6
 */
fun main() {
    val blockChain = FunctionChain(mutableListOf())

    blockChain.addInterceptor { next ->
        {
            println("====> first");
            next(it)
        }
    }
    blockChain.addInterceptor { next ->
        {
            println("====> second");
            next(it)
        }
    }
    val testAction: Action = object : Action {

    }
    blockChain.dispatch(testAction)
}