package com.example.retrofit.data.models

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: String,
    @SerializedName("articles")
    val articles: List<ArticleResponse>
)
