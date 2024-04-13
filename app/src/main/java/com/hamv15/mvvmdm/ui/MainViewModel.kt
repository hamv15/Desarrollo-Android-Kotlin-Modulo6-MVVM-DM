package com.hamv15.mvvmdm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamv15.mvvmdm.data.remote.AnimeProvider
import com.hamv15.mvvmdm.data.remote.model.AnimeDto
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    //Ponemos un contenedor observable livedata
    private val _anime = MutableLiveData<AnimeDto>() //versión mutable e interna
    val anime: LiveData<AnimeDto> = _anime //Esta se accede públicamente y es read-only

    //Ejemplos
    //Un string livedata
    private val _name = MutableLiveData<String>() //Versión mutable e interna
    val name: LiveData<String> = _name //Esta se accede públicamente y es readonly

    private val _numero = MutableLiveData<Long>() //Versión mutable e interna
    val numero: LiveData<Long> = _numero //Esta se accede públicamente y es readonly


    //Generar una función que acceda a la capa de mi modelo
    fun getAnime(){
        //Corrutina
        viewModelScope.launch {
            _anime.postValue(AnimeProvider.getAnimesApi())
        }
    }

    fun getName(){
        _name.postValue("Hugo")
    }

    fun getNumero(){
        _numero.postValue(15)
    }


}