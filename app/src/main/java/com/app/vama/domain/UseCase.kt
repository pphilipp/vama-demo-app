package com.app.vama.domain

interface UseCase<out T, in P> {

    fun execute(params: P): T
}