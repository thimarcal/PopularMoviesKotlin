package gmp.thiago.apps.popularmovies.model

import gmp.thiago.apps.popularmovies.data.Movies

data class MovieListResult(
    val page: Int,
    val results: List<Movies>,
    val total_pages: Int,
    val total_results: Int
)