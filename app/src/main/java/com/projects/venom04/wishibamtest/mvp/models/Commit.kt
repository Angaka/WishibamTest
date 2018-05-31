package com.projects.venom04.wishibamtest.mvp.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Venom on 31/05/2018.
 */
class Commit(
        @SerializedName("sha") val sha: String,
        @SerializedName("node_id") val nodeId: String,
        @SerializedName("commit") val commitDetail: CommitDetail,
        @SerializedName("html_url") val htmlUrl: String,
        @SerializedName("author") val author: Committer? = null,
        @SerializedName("committer") val committer: Committer? = null,
        @SerializedName("stats") val stats: Stats,
        @SerializedName("files") val files: List<File>) {
    override fun toString(): String {
        return "Commit(sha='$sha', nodeId='$nodeId', commitDetail=$commitDetail, htmlUrl='$htmlUrl', author=$author, committer=$committer, stats=$stats, files=$files)"
    }
}