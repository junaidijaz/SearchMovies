package com.simulated.presentation_home

object Constants {

     const val imageBaseUrl = "https://image.tmdb.org/t/p/w500"
     const val imageBaseUrlOriginal = "https://image.tmdb.org/t/p/original"

      enum class MediaTypes(val value: String) {
          TV("tv"), MOVIE("movie"), PERSON("person")
     }
}