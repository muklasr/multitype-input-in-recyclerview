package com.muklasr.edittextinrecyclerviewsandbox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muklasr.edittextinrecyclerviewsandbox.databinding.ItemFoodMenuBinding
import com.muklasr.edittextinrecyclerviewsandbox.model.FoodMenu

class FoodAdapter(private val foodList: ArrayList<FoodMenu>):RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(private val binding: ItemFoodMenuBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(food: FoodMenu){
            binding.food = food
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder =
        FoodViewHolder(ItemFoodMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(food = foodList[position])
    }

    override fun getItemCount(): Int = foodList.size
}