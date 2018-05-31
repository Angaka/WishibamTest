package com.projects.venom04.wishibamtest.mvp.presenters.main

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.projects.venom04.wishibamtest.mvp.models.Commit
import com.projects.venom04.wishibamtest.networks.GithubService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Venom on 31/05/2018.
 */
class MainPresenter(private val mainView: MainView) {

    private val mSubscriptions: CompositeDisposable = CompositeDisposable()

    fun getAllCommits() {
        mSubscriptions.add(
                GithubService.instance.getAllCommitsByAuthorAndRepo("torvalds", "linux")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            val listType = object : TypeToken<List<Commit>>() {}.type
                            val commits = Gson().fromJson<List<Commit>>(it.asJsonArray, listType)

                            mainView.onSuccess(commits)
                        },{
                            mainView.onError(it.message)
                        })
        )
    }

    companion object {
        private const val TAG = "MainPresenter"
    }
}