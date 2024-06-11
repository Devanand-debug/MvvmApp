package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.PostModel
import com.example.myapplication.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(val repository : PostRepository) : ViewModel() {

    private var userData = MutableLiveData<List<PostModel>>()
    val _userData : LiveData<List<PostModel>> = userData

    init {
        fetchUserData()
    }

    private fun fetchUserData() {
        viewModelScope.launch {
            userData.value = repository.getUserData()
        }
    }
}