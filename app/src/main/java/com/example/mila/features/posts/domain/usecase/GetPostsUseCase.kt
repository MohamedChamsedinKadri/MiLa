package com.example.mila.features.posts.domain.usecase

import com.example.mila.features.posts.domain.repository.Postsrepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor
    (private val repo: Postsrepository)

{
    operator fun invoke()= repo.getPosts()
}

