package com.iamageo.ghibli.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.iamageo.ghibli.base.BaseActivity
import com.iamageo.ghibli.data.model.Film
import com.iamageo.ghibli.data.model.adapter.GhibliFilmAdapter
import com.iamageo.ghibli.databinding.ActivityMainBinding
import com.iamageo.ghibli.ui.viewmodel.GhibliViewModel

class GhibliMain : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: GhibliViewModel by viewModels()

    private val adapter by lazy {
        GhibliFilmAdapter(context= this)
    }

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
        adapter.atualiza(list)
        binding.rvFilms.adapter = adapter
        adapter.onFilmClick = this::operDialogDetailsFilm
    }

    private fun operDialogDetailsFilm(film: Film) {
        Toast.makeText(this, film.title, Toast.LENGTH_SHORT).show()
        //make dialog this
    }

}