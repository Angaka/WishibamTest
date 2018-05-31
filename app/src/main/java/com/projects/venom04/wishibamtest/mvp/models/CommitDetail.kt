package com.projects.venom04.wishibamtest.mvp.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Venom on 31/05/2018.
 */
class CommitDetail(
        @SerializedName("author") val author: Committer,
        @SerializedName("committer") val committer: Committer,
        @SerializedName("message") val message: String) {
    override fun toString(): String {
        return "CommitDetail(author=$author, committer=$committer, message='$message')"
    }
}