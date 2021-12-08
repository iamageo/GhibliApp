package com.iamageo.ghibli.data.model

data class Film (
    val title: String,
    val original_title: String,
    val original_title_romanised: String,
    val image: String,
    val movie_banner: String,
    val description: String,
    val director: String,
    val producer: String,
    val release_date: Int,
    val running_time: Int,
    val rt_score: Int
)
