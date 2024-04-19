package com.example.a24001116_synrgy_7_muk_dictionary_ch3.common

sealed class Resource<T>(
    val data: T? = null
) {
    class Success<T>(data: T) : Resource<T>(data = data)
    class Loading<T> : Resource<T>()
}
