package com.example.mila.features.posts.data.repository

import com.example.mila.features.posts.data.remote.PostsApiService
import com.example.mila.features.posts.domain.model.PostsModel
import com.example.mila.features.posts.domain.repository.Postsrepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val apiService: PostsApiService

) : Postsrepository{
    override fun getPosts(): Flow<List<PostsModel>> = flow {
        emit(apiService.getPosts())
    }
}







