package com.alaaeddinalbarghoth.utils.results

data class Success<out T : Any>(val data: T?) : DataResult<T>()
