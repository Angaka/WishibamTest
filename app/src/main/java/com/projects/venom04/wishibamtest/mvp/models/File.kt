package com.projects.venom04.wishibamtest.mvp.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Venom on 31/05/2018.
 */
class File(
        @SerializedName("filename") val filename: String,
        @SerializedName("status") val status: String,
        @SerializedName("additions") val additions: Int,
        @SerializedName("deletions") val deletions: Int,
        @SerializedName("changes") val changes: Int,
        @SerializedName("blob_url") val blobUrl: String) {
    override fun toString(): String {
        return "File(filename='$filename', status='$status', additions=$additions, deletions=$deletions, changes=$changes, blobUrl='$blobUrl')"
    }
}