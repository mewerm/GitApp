package com.maxmesh.gitapp.ui.users

import androidx.lifecycle.LiveData
import com.maxmesh.gitapp.domain.UserEntity

interface UsersContract {

    interface ViewModel {
        val usersLiveData: LiveData<List<UserEntity>>
        val errorLiveData: LiveData<Throwable>
        val progressLiveData: LiveData<Boolean>

        fun onRefresh()
    }
}