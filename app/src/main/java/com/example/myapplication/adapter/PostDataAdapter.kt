package com.example.myapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.PostDataItemBinding
import com.example.myapplication.model.PostModel

class PostDataAdapter(val postDataList : List<PostModel>) : RecyclerView.Adapter<PostDataAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: PostDataItemBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(postDataList: PostModel) {

            binding.tvId.text = "Id : " + postDataList.id.toString()
            binding.tvUserId.text = "UserId : " + postDataList.userId.toString()
            binding.tvTitle.text = "Title : " + postDataList.title
            binding.tvBody.text = "Body : " + postDataList.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       // val view = LayoutInflater.from(parent.context).inflate(R.layout.post_data_item, parent, false)
        val binding = PostDataItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(postDataList[position])
        holder.adapterPosition
    }

    override fun getItemCount(): Int {
        return postDataList.size
    }
}