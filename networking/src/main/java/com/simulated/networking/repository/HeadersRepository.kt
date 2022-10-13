package com.simulated.networking.repository

import okhttp3.Interceptor

interface HeadersRepository {

    fun versionCodeHeader(): Interceptor

    fun appHeader(): Interceptor

    fun langHeader(): Interceptor

    fun deviceIdHeader(): Interceptor
}