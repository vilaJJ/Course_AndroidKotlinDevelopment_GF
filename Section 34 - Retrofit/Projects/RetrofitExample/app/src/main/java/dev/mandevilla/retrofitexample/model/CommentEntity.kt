package dev.mandevilla.retrofitexample.model

data class CommentEntity(
    val id: Int,
    val postId: Int,
    val name: String,
    val email: String,
    val body: String
)
