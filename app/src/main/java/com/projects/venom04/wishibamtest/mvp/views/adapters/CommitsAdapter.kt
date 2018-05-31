package com.projects.venom04.wishibamtest.mvp.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.projects.venom04.wishibamtest.R
import com.projects.venom04.wishibamtest.mvp.models.Commit
import com.projects.venom04.wishibamtest.utils.DateHelper
import com.projects.venom04.wishibamtest.utils.GlideApp
import kotlinx.android.synthetic.main.item_commit.view.*

/**
 * Created by Venom on 31/05/2018.
 */
class CommitsAdapter(private val items: List<Commit>, private val itemClick: (String) -> Unit) : RecyclerView.Adapter<CommitsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_commit, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(itemView: View, private val itemClick: (String) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Commit) {
            with(item) {
                if (item.committer?.avatarUrl != null) {
                    GlideApp.with(itemView)
                            .load(item.committer.avatarUrl)
                            .into(itemView.imageView_avatar)
                }
                itemView.imageView_avatar.setOnClickListener {
                    itemClick(item.htmlUrl)
                }
                itemView.textView_message.text = item.commitDetail.message
                itemView.textView_committer.text = item.commitDetail.committer.name
                itemView.textView_date.text = DateHelper.formatStringDate(item.commitDetail.committer.date)
            }
        }
    }
}