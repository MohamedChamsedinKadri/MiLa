package com.example.mila.features.posts.presentation

import com.example.mila.features.posts.domain.model.PostsModel

sealed class PostsState {
    object Loading : PostsState()
    data class Success(val posts: List<PostsModel>) : PostsState()
    object Empty : PostsState()
    data class Error(val message: String) : PostsState()

}







