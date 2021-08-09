package com.stevehechio.apps.foodmanic.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stevehechio.apps.foodmanic.data.model.FoodCat
import com.stevehechio.apps.foodmanic.databinding.ItemCategoryListBinding

/**
 * Created by stevehechio on 8/9/21
 */
class CategoryAdapter(val context: Context) : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {
    var foodList = ArrayList<FoodCat>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        return CategoryHolder(ItemCategoryListBinding.inflate(LayoutInflater.from(parent.context)
            ,parent,false))
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bindViews(foodCat = foodList[position])
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
    inner class CategoryHolder(private val binding: ItemCategoryListBinding): RecyclerView.ViewHolder(binding.root){
       fun bindViews(foodCat: FoodCat){
           setHeader(foodCat.name)
           val adapter = FoodAdapter(foodList = foodCat.list,context)
           if (foodCat.name == "Popular Meals"){
               bindHorizontalRecyclerViews(context = context,mAdapter = adapter)
           }else {
               bindRecyclerViews(context = context,mAdapter = adapter)
           }
       }


        private fun bindRecyclerViews(context: Context, mAdapter: FoodAdapter){
        binding.rvCat.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }
        }
        private fun bindHorizontalRecyclerViews(context: Context, mAdapter: FoodAdapter){
        binding.rvCat.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = mAdapter
        }
        }

        private fun setHeader(category: String){
            binding.txtCat.text = category
        }
    }
}