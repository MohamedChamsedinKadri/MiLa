package com.example.mila.features.posts.domain.repository

import com.example.mila.features.posts.domain.model.PostsModel
import kotlinx.coroutines.flow.Flow

interface Postsrepository {
    fun getPosts(): Flow<List<PostsModel>>


}



