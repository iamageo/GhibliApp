package com.iamageo.ghibli.data

import com.iamageo.ghibli.data.network.GhibliService
import com.iamageo.ghibli.data.network.response.ResponseGhibli

class GhibliRepository {

    private val ghibli = GhibliService()

    suspend fun getAllMovies() : ResponseGhibli {
        return ghibli.getAllMovies()
    }

}