package com.sanyinchen.block

import com.sanyinchen.block.base.Action

/**
 * Created by sanyinchen on 19-11-6.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-11-6
 */

typealias DispatchFunction = (Action) -> Unit

typealias Interceptor = (DispatchFunction) -> DispatchFunction