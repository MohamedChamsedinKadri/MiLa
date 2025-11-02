package com.example.mila.features.posts.data.remote

import com.example.mila.features.posts.domain.model.PostsModel
import retrofit2.http.GET

interface PostsApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostsModel>
}




