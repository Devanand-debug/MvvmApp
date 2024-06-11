package com.example.myapplication.api

import com.example.myapplication.model.PostModel
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPostUser() : List<PostModel>
}