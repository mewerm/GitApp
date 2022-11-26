package com.maxmesh.gitapp.ui.users

import com.maxmesh.gitapp.domain.UserEntity
import com.maxmesh.gitapp.domain.UsersRepo

class UsersPresenter(
    private val usersRepo: UsersRepo
) : UsersContract.Presenter {

    private var view: UsersContract.View? = null

    private var usersList: List<UserEntity>? = null
    private var inProgress: Boolean = false

    override fun attach(view: UsersContract.View) {
        this.view = view
        view.showProgress(inProgress)
        usersList?.let { view.showUsers(it) }
    }

    override fun detach() {
        view = null
    }

    override fun onRefresh() {
        loadData()
    }

    private fun loadData() {
        view?.showProgress(true)
        inProgress = true
        usersRepo.getUsers(
            onSuccess = {
                view?.showProgress(false)
                view?.showUsers(it)
                usersList = it
                inProgress = false
            }, onError = {
                view?.showProgress(false)
                view?.showError(it)
                inProgress = false
            })
    }
}