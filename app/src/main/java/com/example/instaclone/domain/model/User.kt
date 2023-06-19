package com.example.instaclone.domain.model

data class User(
    val name: String = "",
    var userName: String = "",
    var userId: String = "",
    var email: String = "",
    var password: String = "",
    var imageUrl: String = "",
    var following: List<String> = emptyList(),
    var followers: List<String> = emptyList(),
    var totalPosts: String = "",
    var bio: String = "",
    var url: String = ""
)
