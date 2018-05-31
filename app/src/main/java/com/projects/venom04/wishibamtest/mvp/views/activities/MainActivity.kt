package com.projects.venom04.wishibamtest.mvp.views.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import androidx.core.net.toUri
import com.projects.venom04.wishibamtest.BuildConfig
import com.projects.venom04.wishibamtest.R
import com.projects.venom04.wishibamtest.mvp.models.Commit
import com.projects.venom04.wishibamtest.mvp.presenters.main.MainPresenter
import com.projects.venom04.wishibamtest.mvp.presenters.main.MainView
import com.projects.venom04.wishibamtest.mvp.views.adapters.CommitsAdapter
import com.projects.venom04.wishibamtest.utils.SpacesItemDecoration
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import java.util.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var mMainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_commits.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView_commits.addItemDecoration(SpacesItemDecoration(8))
        recyclerView_commits.adapter = CommitsAdapter(ArrayList(), {})

        mMainPresenter = MainPresenter(this)
        mMainPresenter.getAllCommits()
    }

    override fun onSuccess(commits: List<Commit>) {
        recyclerView_commits.adapter = CommitsAdapter(commits, {
            val intent = Intent(Intent.ACTION_VIEW, it.toUri())
            startActivity(intent)
        })
    }

    override fun onError(error: String?) {
        if (error != null) {
            if (BuildConfig.DEBUG)
                Log.e(TAG, error)
            longToast(error)
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
