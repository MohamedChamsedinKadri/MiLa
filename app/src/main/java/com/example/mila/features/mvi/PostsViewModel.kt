package com.example.mila.features.mvi

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    //state flow to hold ui state
    private val _state = MutableStateFlow<PostsState>(PostsState.Loading)
    val state: StateFlow<PostsState> = _state.asStateFlow()


    private val _intent = MutableSharedFlow<PostsIntent>()

    init {
        handleIntent()
        loadPosts()
    }

    private fun handleIntent(){
        viewModelScope.launch {
            _intent.collect{ intent -> when(intent){
                is PostsIntent.LoadPosts -> loadPosts()
            }
            }
        }

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




