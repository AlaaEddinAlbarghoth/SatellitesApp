package com.alaaeddinalbarghoth.cache.source

import com.alaaeddinalbarghoth.cache.BuildConfig
import com.alaaeddinalbarghoth.utils.results.DataResult
import com.alaaeddinalbarghoth.utils.results.Success
import com.alaaeddinalbarghoth.utils.results.Error
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.io.IOException

open class LocalDataSource {

    open suspend fun <T> safeLoadJson(
        dispatcher: CoroutineDispatcher,
        apiCall: suspend () -> T,
    ): DataResult<T> {
        return withContext(dispatcher) {
            try {
                Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                if (BuildConfig.DEBUG)
                    throwable.printStackTrace()
                when (throwable) {
                    is IOException -> return@withContext Error("Can't read file that store data")
                    else -> return@withContext Error("Unknown Exception")
                }
            }
        }
    }
}
