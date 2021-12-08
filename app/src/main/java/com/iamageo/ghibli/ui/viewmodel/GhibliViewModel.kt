package com.iamageo.ghibli.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamageo.ghibli.data.model.Film
import com.iamageo.ghibli.domain.GhibliUseCase
import kotlinx.coroutines.launch

class GhibliViewModel: ViewModel() {

    var GhibliFilmList = MutableLiveData<List<Film>>()

    var ResponseObject = GhibliUseCase()

    fun getAllPlanets() {
        viewModelScope.launch {
            GhibliFilmList.value = ResponseObject.invoke().films
        }
    }


}