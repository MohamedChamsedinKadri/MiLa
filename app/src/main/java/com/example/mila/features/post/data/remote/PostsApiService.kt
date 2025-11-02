package com.example.mila.features.post.data.remote

import com.example.mila.features.domain.model.PostsModel
import retrofit2.http.GET

interface PostsApiService {
    @GET("  posts")
    suspend fun getPosts(): List<PostsModel>
}


}

