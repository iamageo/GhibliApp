package com.iamageo.ghibli.domain

import com.iamageo.ghibli.data.GhibliRepository
import com.iamageo.ghibli.data.network.response.ResponseGhibli

class GhibliUseCase {

    private val repository = GhibliRepository()

    suspend operator fun invoke(): ResponseGhibli = repository.getAllMovies()

}