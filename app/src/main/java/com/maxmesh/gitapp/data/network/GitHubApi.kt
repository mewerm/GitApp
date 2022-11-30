package com.maxmesh.gitapp.data.network

import com.maxmesh.gitapp.domain.UserEntity
import retrofit2.Call
import retrofit2.http.GET

interface GitHubApi {
    @GET("users")
    fun getUsers(): Call<List<UserEntity>>
}