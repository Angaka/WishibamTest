package com.projects.venom04.wishibamtest.mvp.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Venom on 31/05/2018.
 */
class Committer(
        @SerializedName("name") val name: String,
        @SerializedName("date") val date: String,
        @SerializedName("avatar_url") val avatarUrl: String? = null) {
    override fun toString(): String {
        return "Committer(name='$name', date='$date', avatarUrl='$avatarUrl')"
    }
}