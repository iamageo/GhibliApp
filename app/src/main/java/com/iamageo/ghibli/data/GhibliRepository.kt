package com.iamageo.ghibli.data

import com.iamageo.ghibli.data.model.Film
import com.iamageo.ghibli.data.network.GhibliService
import javax.inject.Inject

class GhibliRepository @Inject constructor(private val service: GhibliService) {

    suspend fun getAllMovies(): List<Film> {
        return service.getAllMovies()
    }

}