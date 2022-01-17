package com.iamageo.ghibli.data.model.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iamageo.ghibli.data.model.Film
import com.iamageo.ghibli.databinding.FilmBinding
import com.iamageo.ghibli.utils.IntToHoursAndMinutes
import com.squareup.picasso.Picasso

class GhibliFilmAdapter(private val films: MutableList<Film> = mutableListOf(),
                        private val context: Context,
                        var onFilmClick: (film: Film) -> Unit = {}
    ): RecyclerView.Adapter<GhibliFilmAdapter.ViewHolder>() {

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

        internal fun render(film: Film) {
            //itemBinding.filmTitle.text = film.title
            //itemBinding.filmDuration.text = IntToHoursAndMinutes(film.running_time)
            Picasso.get().load(film.image).into(itemBinding.filmBanner)

            itemView.setOnClickListener {
                onFilmClick(film)
            }
        }

    }

    fun atualiza(list: List<Film>) {
        this.films.clear()
        this.films.addAll(list)
    }

}