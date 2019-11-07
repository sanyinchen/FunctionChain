# FunctionChain
A very short and capable sequential function lib by kotlin.

### Foo:
```
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
```

### output:
```
wrap===> second
wrap===> first
====> first
====> second
com.sanyinchen.foo.MainKt$main$testAction$1@72ea2f77
```
