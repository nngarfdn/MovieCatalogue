package com.nanangarifudin.moviecatalogue.data.remote.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResponse(
    var page: Int?,
    var results: List<Result>?,
    var total_pages: Int?,
    var total_results: Int?
)