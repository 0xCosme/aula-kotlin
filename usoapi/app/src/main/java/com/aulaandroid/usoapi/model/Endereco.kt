package com.aulaandroid.usoapi.model

import com.google.gson.annotations.SerializedName

data class Endereco (
    val uf: String ="",
    val cep: String ="",
    @SerializedName("logradouro") val rua: String ="",
    @SerializedName("localidade") val cidade: String ="",
    val bairro: String =""

    ){



}