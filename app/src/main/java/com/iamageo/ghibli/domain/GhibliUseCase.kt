package com.iamageo.ghibli.domain

import com.iamageo.ghibli.data.GhibliRepository
import com.iamageo.ghibli.data.model.Film
import javax.inject.Inject

class GhibliUseCase @Inject constructor(private val repository: GhibliRepository) {

    suspend operator fun invoke(): List<Film> = repository.getAllMovies()

}