package com.sefakose.kotlintodoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sefakose.kotlintodoapp.databinding.ItemCardViewBinding

class ToDoAdapter(private val list:ArrayList<Item>): RecyclerView.Adapter<ToDoAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(private val binding: ItemCardViewBinding) :
        ViewHolder(binding.root) {
        fun bind(item: Item) {
            item.apply {
                binding.tvTitle.text = title
                binding.tvDescription.text = description
                binding.checkbox.isChecked = isDone
            }
            binding.btnDel.setOnClickListener {
                list.remove(item)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ItemCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(list[position])
    }
}