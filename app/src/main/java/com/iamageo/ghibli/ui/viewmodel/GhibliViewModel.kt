package com.iamageo.ghibli.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamageo.ghibli.data.model.Film
import com.iamageo.ghibli.domain.GhibliUseCase
import kotlinx.coroutines.launch

class GhibliViewModel @ViewModelInject constructor(private val useCase: GhibliUseCase) :
    ViewModel() {

    var GhibliFilmList = MutableLiveData<List<Film>>()

    fun getAllPlanets() {
        viewModelScope.launch {
            GhibliFilmList.value = useCase.invoke()
        }
    }


}