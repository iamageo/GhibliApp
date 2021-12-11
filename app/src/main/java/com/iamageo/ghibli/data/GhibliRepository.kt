package com.iamageo.ghibli.data

import com.iamageo.ghibli.data.model.Film
import com.iamageo.ghibli.data.network.GhibliService

class GhibliRepository {

    private val ghibli = GhibliService()

    suspend fun getAllMovies() : List<Film> {
        return ghibli.getAllMovies()
    }

}