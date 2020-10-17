package com.ciechu.brewdogrecipes.core.base

import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params, in Params2, in Params3> {

    abstract suspend fun action(params: Params, params2: Params2, params3: Params3): Type

    operator fun invoke(
        params: Params,
        params2: Params2,
        params3: Params3,
        scope: CoroutineScope,
        executionDispatcher: CoroutineDispatcher = Dispatchers.IO,
        onResult: (Result<Type>) -> Unit = {}
    ) {
        scope.launch {
            val result = withContext(executionDispatcher) {
                runCatching { action(params, params2, params3) }
            }
            onResult(result)
        }
    }
}