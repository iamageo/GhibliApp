package com.iamageo.ghibli.data.network

import com.iamageo.ghibli.data.model.Film
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GhibliService @Inject constructor(private val api: GhibliAPI) {

    suspend fun getAllMovies(): List<Film> {
        return withContext(Dispatchers.IO) {
            api.getAllMovies()
        }
    }


}