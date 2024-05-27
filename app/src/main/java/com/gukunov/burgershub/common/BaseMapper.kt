package com.gukunov.burgershub.common

interface BaseMapper<Input, Output> {
    fun map(input : Input) : Output
}