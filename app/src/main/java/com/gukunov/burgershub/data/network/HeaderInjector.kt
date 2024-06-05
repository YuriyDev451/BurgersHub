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
            .addHeader("X-RapidAPI-Key", "8274eddd5cmsh7ee221d33002e47p199729jsn217aeed6b45f")
            .addHeader("X-RapidAPI-Host", "burgers-hub.p.rapidapi.com")

        return chain.proceed(authRequest.build())
    }



}