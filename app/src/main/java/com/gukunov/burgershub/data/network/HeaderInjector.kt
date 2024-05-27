package com.gukunov.burgershub.data.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeaderInjector @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val authRequest = originalRequest.newBuilder()
            .addHeader("X-RapidAPI-Key", "7844d08053mshc200634488b4192p1d70cdjsn933b6a71c6c0")
            .addHeader("X-RapidAPI-Host", "burgers-hub.p.rapidapi.com")

        return chain.proceed(authRequest.build())
    }



}