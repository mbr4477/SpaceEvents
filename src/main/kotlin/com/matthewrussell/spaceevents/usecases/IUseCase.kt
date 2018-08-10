package com.matthewrussell.spaceevents

interface IUseCase<T, R> {
    fun execute(input: T): R
}