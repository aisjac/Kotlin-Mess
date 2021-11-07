package com.example.kotlinmess.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class apiController internal constructor() {
    fun getapi(): Api {
        return retrofit.create(Api::class.java)
    }

    companion object {
        private const val url = "http://103.69.150.122:8002/"
        private var clientobject: apiController? = null
        private lateinit var retrofit: Retrofit

        @get:Synchronized
        val instance: apiController?
            get() {
                if (clientobject == null) clientobject = apiController()
                return clientobject
            }
    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}