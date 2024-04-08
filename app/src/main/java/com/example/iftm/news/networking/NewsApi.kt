package com.example.iftm.news.networking


data class NewsApi(
    val totalResults: Int,
    val articles: List<Article>
)