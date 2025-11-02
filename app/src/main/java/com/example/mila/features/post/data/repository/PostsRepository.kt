package com.example.mila.features.post.data.repository

import com.example.mila.features.domain.model.PostsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostsRepository @Inject constructor(
    private val apiService: PostApiService

) {
    fun getAllPosts(): Flow<List<PostsModel>> = flow{
        val response = apiService.getPosts()

        emit(response)
    }
}


