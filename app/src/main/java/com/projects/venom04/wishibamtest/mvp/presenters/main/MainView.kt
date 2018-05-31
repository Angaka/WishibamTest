package com.projects.venom04.wishibamtest.mvp.presenters.main

import com.projects.venom04.wishibamtest.mvp.models.Commit

/**
 * Created by Venom on 31/05/2018.
 */
interface MainView {
    fun onSuccess(commits: List<Commit>)
    fun onError(error: String?)
}