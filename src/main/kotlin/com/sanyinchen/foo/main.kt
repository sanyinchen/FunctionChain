package com.sanyinchen.foo

import com.sanyinchen.block.DispatchFunction
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
    val blockChain = FunctionChain(mutableListOf(), { action ->
        println(action)
    })

    blockChain.addInterceptor first@{ next ->
        println("wrap===> first")
        return@first {
            println("====> first");
            next(it)
        }
    }
    blockChain.addInterceptor second@{ next: DispatchFunction ->
        println("wrap===> second")
        return@second {
            println("====> second");
            next(it)
        }
    }
    val testAction: Action = object : Action {
    }
    blockChain.dispatch(testAction)
}