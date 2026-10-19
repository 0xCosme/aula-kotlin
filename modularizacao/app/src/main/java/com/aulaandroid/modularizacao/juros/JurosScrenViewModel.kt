package com.aulaandroid.modularizacao.juros

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JurosScrenViewModel: ViewModel() {

    private val _capital = MutableLiveData<String>()
    private val _taxa = MutableLiveData<String>("")
    private val _tempo = MutableLiveData<String>("")
    private val _juros = MutableLiveData<Double>(0.0)
    private val _montante = MutableLiveData<Double>(0.0)
    val capital: LiveData<String> =_capital
    val taxa: LiveData<String> =_taxa
    val tempo: LiveData<String> =_tempo
    val juros: LiveData<Double> =_juros
    val montante: LiveData<Double> =_montante


    fun onCapitalChanged(novoCapital: String){
        _capital.value = novoCapital
    }
}