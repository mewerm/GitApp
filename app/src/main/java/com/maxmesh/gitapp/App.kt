package com.maxmesh.gitapp

import android.app.Application
import android.content.Context
import com.maxmesh.gitapp.data.network.RetrofitUsersRepoImpl
import com.maxmesh.gitapp.domain.UsersRepo

class App : Application() {
     val usersRepo: UsersRepo by lazy { RetrofitUsersRepoImpl() }
}
val Context.app: App get() = applicationContext as App