package com.maxmesh.gitapp.domain

import com.squareup.moshi.Json

data class UserEntity(
    val login: String,
    val id: Long,
    @field:Json(name = "avatar_url")
    val avatarUrl: String
)
