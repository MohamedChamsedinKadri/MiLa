package com.example.mila.features.posts.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mila.features.posts.domain.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    //state flow to hold ui state
    private val _state = MutableStateFlow<PostsState>(PostsState.Loading)
    val state: StateFlow<PostsState> = _state.asStateFlow()



    init {
        loadPosts()
    }


    private fun loadPosts(){
        viewModelScope.launch {
            getPostsUseCase()
                .catch {e ->
                    _state.value = PostsState.Error(e.message ?: "An unknown error occurred")
                }
                .collect{ posts ->
                _state.value = if (posts.isEmpty()){
                    PostsState.Empty
                }else{
                    PostsState.Success(posts)
                }
            }
        }
    }
}




