package com.example.rxandroidapp.ui.firstFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rxandroidapp.R
import com.example.rxandroidapp.data.Post

class FirstRecyclerAdapter(
    private val context: Context,
    private val posts: List<Post>
) : RecyclerView.Adapter<FirstRecyclerAdapter.FirstViewHolder>() {

    class FirstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val textBody: TextView = itemView.findViewById(R.id.textViewBody)
        val textUserId: TextView = itemView.findViewById(R.id.textViewUserId)
        val textId: TextView = itemView.findViewById(R.id.textViewId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.first_card, parent, false)
        return FirstViewHolder(v)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {

        val post: Post = posts[position]
        holder.textId.text = post.id.toString()
        holder.textBody.text = post.body
        holder.textTitle.text = post.title
        holder.textUserId.text = post.userId.toString()

    }
}