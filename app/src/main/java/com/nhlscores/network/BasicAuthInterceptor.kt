package com.nhlscores.network

import okhttp3.Response
import okhttp3.Credentials
import okhttp3.Interceptor
import java.io.IOException

class BasicAuthInterceptor(token: String, password: String) : Interceptor {
    private val credentials: String = Credentials.basic(token, password)

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val req = chain.request()
        val authenticatedRequest = req.newBuilder()
            .header("Authorization", credentials).build()
        return chain.proceed(authenticatedRequest)
    }
}