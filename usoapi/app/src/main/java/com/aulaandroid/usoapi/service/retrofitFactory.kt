package com.aulaandroid.usoapi.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class retrofitFactory {

    private val BASE_URL = "https://viacep.com.br/ws/"
    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getEnderecoService(): EnderecoService{
        return retrofitFactory.create(EnderecoService::class.java)
    }
}