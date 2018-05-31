package com.projects.venom04.wishibamtest.networks

import com.google.gson.JsonArray
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by Venom on 31/05/2018.
 */
interface GithubService {

    companion object {
        val instance: GithubService by lazy {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com/repos/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build()
            retrofit.create(GithubService::class.java)
        }
    }

    @Headers("Content-Type: application/json")
    @GET("torvalds/linux/commits")
    fun getAllCommitsByAuthorAndRepo(@Query("owner") owner: String, @Query("repo") repo: String) : Observable<JsonArray>
}