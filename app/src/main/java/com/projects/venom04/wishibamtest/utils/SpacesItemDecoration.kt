package com.projects.venom04.wishibamtest.utils

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View


/**
 * Created by Venom on 25/02/2018.
 */
class SpacesItemDecoration(private val mSpace: Int,
                           private var mInWidth: Boolean = true,
                           private var mInHeight: Boolean = true) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (mInWidth) {
            outRect.left = mSpace
            outRect.right = mSpace
        }
        if (mInHeight) {
            outRect.top = mSpace
            outRect.bottom = mSpace
        }
    }
}