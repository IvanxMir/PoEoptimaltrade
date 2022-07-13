package com.example.poeoptimaltrade.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.poeoptimaltrade.database.entity.Category
import com.example.poeoptimaltrade.databinding.CategoryItemViewBinding

class CategoryAdapter(private val clickListener: CategoryListener): ListAdapter<Category, CategoryItemViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
        return CategoryItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }
}

class CategoryItemViewHolder private constructor(val binding: CategoryItemViewBinding): RecyclerView.ViewHolder(binding.root) {
    private val categoryText: TextView = binding.categoryText
    private val categoryImg: ImageView = binding.categoryImg

    fun bind(item: Category, clickListener: CategoryListener) {
        binding.category = item
        binding.executePendingBindings()
        binding.clickListener = clickListener
        categoryText.text = item.name.toString()
        Glide.with(categoryImg.context).load(item.url).into(categoryImg)
    }

    companion object {
        fun from(parent: ViewGroup): CategoryItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = CategoryItemViewBinding.inflate(layoutInflater, parent, false)
            return CategoryItemViewHolder(binding)
        }
    }
}

class CategoryDiffCallback: DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.categoryId == newItem.categoryId
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}

class CategoryListener(val clickListener: (categoryId: Int) -> Unit) {
    fun onClick(category: Category) = clickListener(category.categoryId)
}