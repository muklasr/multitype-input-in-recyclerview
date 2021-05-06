package com.muklasr.edittextinrecyclerviewsandbox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muklasr.edittextinrecyclerviewsandbox.databinding.ItemCategoryBinding
import com.muklasr.edittextinrecyclerviewsandbox.model.Category
import com.muklasr.edittextinrecyclerviewsandbox.model.Variable

class CategoryAdapter(
    private val categoryList: ArrayList<Category>,
    private val variableList: ArrayList<Variable>
    ): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(category: Category){
            binding.category = category

            val filteredList = variableList.filter { it.categoryId == category.id } as ArrayList<Variable>
            val variableAdapter = VariableAdapter(filteredList)
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                adapter = variableAdapter
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(category = categoryList[position])
    }

    override fun getItemCount(): Int = categoryList.size

}