package com.app.vama.util

import android.util.Log

suspend fun <S> retry(attempt: Int, block: suspend () -> S): S {
    repeat(attempt) {
        try {
            block()
        } catch (e: Throwable) {
            Log.e("retry", "Repeat occurred with error - $e")
        }
    }
    return block()
}