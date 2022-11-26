package com.maxmesh.gitapp.ui.users

import com.maxmesh.gitapp.domain.UsersRepo

class UsersPresenter(
    private val usersRepo: UsersRepo
) : UsersContract.Presenter {

    private var view: UsersContract.View? = null

    override fun attach(view: UsersContract.View) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

    override fun onRefresh() {
        loadData()
    }

    private fun loadData() {
        view?.showProgress(true)
        usersRepo.getUsers(
            onSuccess = {
                view?.showProgress(false)
                view?.showUsers(it)
            }, onError = {
                view?.showProgress(false)
                view?.showError(it)
            })
    }
}