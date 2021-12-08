package com.iamageo.ghibli.data.model.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iamageo.ghibli.data.model.Film
import com.iamageo.ghibli.databinding.FilmBinding
import com.squareup.picasso.Picasso

class GhibliFilmAdapter(private val films: List<Film>, private val context: Context): RecyclerView.Adapter<GhibliFilmAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return films.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = FilmBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(films[position])
    }

    inner class ViewHolder(val itemBinding: FilmBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun render(film: Film) {
            itemBinding.filmTitle.text = film.original_title
            itemBinding.filmDuration.text = film.running_time.toString()
            Picasso.get().load(film.movie_banner).into(itemBinding.filmBanner)
        }
    }

}