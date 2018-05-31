package com.projects.venom04.wishibamtest.mvp.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Venom on 31/05/2018.
 */
class Stats(
        @SerializedName("total") val total: Int,
        @SerializedName("additions") val additions: Int,
        @SerializedName("deletions") val deletions: Int) {
    override fun toString(): String {
        return "Stats(total=$total, additions=$additions, deletions=$deletions)"
    }
}