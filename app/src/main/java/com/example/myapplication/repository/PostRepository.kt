package com.example.myapplication.repository

import com.example.myapplication.api.ApiService
import com.example.myapplication.model.PostModel
import javax.inject.Inject

class PostRepository @Inject constructor(val apiService: ApiService) {

    suspend fun getUserData() : List<PostModel>{
        return apiService.getPostUser()
    }
}