package com.iamageo.ghibli.ui.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.iamageo.ghibli.R
import com.iamageo.ghibli.base.BaseActivity
import com.iamageo.ghibli.data.model.Film
import com.iamageo.ghibli.data.model.adapter.GhibliFilmAdapter
import com.iamageo.ghibli.databinding.ActivityMainBinding
import com.iamageo.ghibli.ui.viewmodel.GhibliViewModel
import com.iamageo.ghibli.utils.IntToHoursAndMinutes
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GhibliMain : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: GhibliViewModel by viewModels()

    private val adapter by lazy {
        GhibliFilmAdapter(context = this)
    }

    private val builder by lazy {
        AlertDialog.Builder(this)
    }

    private val view by lazy {
        View.inflate(this, R.layout.dialog, null)
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

    private fun setupDialog(film: Film) {

        setupDialogDetailsFilm(film)
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        setupCloseDialogDetails()

    }

    private fun setupCloseDialogDetails() {
        val closeDialog = view.findViewById<ImageView>(R.id.close_dialog)
        closeDialog.setOnClickListener {
            dialog.hide()
        }
    }

    private fun setupDialogDetailsFilm(film: Film) {
        val tvName = view.findViewById<TextView>(R.id.filmName)
        tvName.text = film.title

        val tvDescription = view.findViewById<TextView>(R.id.filmDescription)
        tvDescription.text = film.description

        val tvDirector = view.findViewById<TextView>(R.id.filmDirector)
        tvDirector.text = "Director: " + film.director

        val tvProducer = view.findViewById<TextView>(R.id.filmProducer)
        tvProducer.text = "Producer: " + film.producer

        val tvYear = view.findViewById<TextView>(R.id.filmYear)
        tvYear.text = "Year: " + film.release_date.toString()

        val tvScore = view.findViewById<TextView>(R.id.movie_detail_rating)
        tvScore.text = film.rt_score.toString()

        val tvDuration = view.findViewById<TextView>(R.id.movie_detail_duration)
        tvDuration.text = IntToHoursAndMinutes(film.running_time)

        val imvFilmBanner = view.findViewById<ImageView>(R.id.filmBanner)
        Picasso.get().load(film.image).into(imvFilmBanner)
    }

    private fun setupAllMovies() {
        viewModel.getAllPlanets()
    }

    private fun setupObservers() {
        viewModel.GhibliFilmList.observe(this, {
            binding.loadingProgressBar.visibility = View.GONE
            setupRecyclerView(it)
        })
    }

    private fun setupRecyclerView(list: List<Film>) {
        adapter.atualiza(list)
        val layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvFilms.adapter = adapter
        binding.rvFilms.layoutManager = layoutManager
        adapter.onFilmClick = this::operDialogDetailsFilm
    }

    private fun operDialogDetailsFilm(film: Film) {
        setupDialog(film)
    }

}