package com.iamageo.ghibli.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.iamageo.ghibli.R
import com.iamageo.ghibli.data.model.Film
import com.iamageo.ghibli.data.model.adapter.GhibliFilmAdapter
import com.iamageo.ghibli.databinding.ActivityMainBinding
import com.iamageo.ghibli.ui.viewmodel.GhibliViewModel

class GhibliMain : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: GhibliViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupAllMovies()
        setupObservers()
    }

    private fun setupAllMovies() {
        viewModel.getAllPlanets()
    }

    private fun setupObservers() {
        viewModel.GhibliFilmList.observe(this, {
            setupRecyclerView(it)
        })
    }


    private fun setupRecyclerView(list: List<Film>) {
        binding.rvFilms.adapter = GhibliFilmAdapter(list, this)
    }

}