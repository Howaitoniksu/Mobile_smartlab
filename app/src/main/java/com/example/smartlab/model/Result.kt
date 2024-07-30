package com.example.smartlab.model

import android.health.connect.datatypes.ExerciseRoute
import android.webkit.WebStorage

class Result {
    data class Result(
        val created: String,
        val episode: List<String>,
        val gender: String,
        val id: Int,
        val image: String,
        val location: ExerciseRoute.Location,
        val name: String,
        val origin: WebStorage.Origin,
        val species: String,
        val status: String,
        val type: String,
        val url: String
    )
}