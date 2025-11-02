package com.example.mila.features.mvi

import com.example.mila.features.domain.model.PostsModel

sealed class PostsState {
    object Loading : PostsState()
    data class Success(val posts: List<PostsModel>) : PostsState()
    object Empty : PostsState()
    data class Error(val message: String) : PostsState()

}