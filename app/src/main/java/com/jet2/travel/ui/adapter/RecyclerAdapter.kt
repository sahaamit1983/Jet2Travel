package com.jet2.travel.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jet2.travel.R
import com.jet2.travel.model.Blogs
import com.jet2.travel.util.BlogUtil
import kotlinx.android.synthetic.main.inflate_recyclerview.view.*

class RecyclerAdapter(private val blogs: List<Blogs>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.inflate_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(blogs[position])
    }

    override fun getItemCount() = blogs.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(blog: Blogs?) {
            try {
                Glide.with(itemView.context).load(blog?.user?.get(0)?.avatar)
                    .into(itemView.circular_image)
                Glide.with(itemView.context).load(blog?.media?.get(0)?.image)
                    .into(itemView.article_image)
                itemView.username.text =
                    blog?.user?.get(0)?.name + " " + blog?.user?.get(0)?.lastname
                itemView.userdesignation.text = blog?.user?.get(0)?.designation
                itemView.about.text = blog?.content
                itemView.title.text = blog?.media?.get(0)?.title
                itemView.like.text = BlogUtil.convertToK(blog?.likes) + " Likes"
                itemView.comment.text = BlogUtil.convertToK(blog?.comments) + " Comments"
                itemView.time.text = BlogUtil.convertTime(blog?.createdAt!!)
            } catch (e : Exception){
                e.printStackTrace()
            }
        }
    }
}