package com.maxmesh.gitapp

interface UsersRepo {
    //CRUD
    //Create
    //Read
    //Update
    //Delete

    //Here is read only
    fun getUsers(
        onSuccess: (List<UserEntity>) -> Unit,
        onError: ((Throwable) -> Unit)? = null
    )

}