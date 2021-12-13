package com.iamageo.ghibli.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.iamageo.ghibli.R
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

    private val builder by lazy {
        AlertDialog.Builder(this)
    }

    private val view by lazy {
        View.inflate(this, R.layout.dialog,null)
    }

    private val dialog by lazy {
        builder.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initDialog()
        setupAllMovies()
        setupObservers()
    }

    private fun initDialog() {
        builder.setView(view)
    }

    private fun setupDialog(name: String, desciption: String) {

        val tvName = view.findViewById<TextView>(R.id.filmName)
        tvName.text = name

        val tvDescription = view.findViewById<TextView>(R.id.filmDescription)
        tvDescription.text = desciption
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
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
        setupDialog(film.title, film.description)
    }

}