package com.stevehechio.apps.foodmanic.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stevehechio.apps.foodmanic.R
import com.stevehechio.apps.foodmanic.data.model.Food
import com.stevehechio.apps.foodmanic.databinding.ItemFoodListBinding
import android.view.animation.ScaleAnimation
import java.util.*


/**
 * Created by stevehechio on 8/9/21
 */
class FoodAdapter(private val foodList: List<Food>,val context: Context):
    RecyclerView.Adapter<FoodAdapter.FoodHolder>() {
    private var lastPosition = -1
    var onClickLikedListener :OnClickLikedListener? = null


    fun setOnClickedLike(onClickLikedListener: OnClickLikedListener){
        this.onClickLikedListener = onClickLikedListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
       return FoodHolder(ItemFoodListBinding.
       inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.bindViews(foodList[position])
        setAnimation(holder.itemView,position)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
    private fun setAnimation(viewToAnimate: View, position: Int) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            val anim = ScaleAnimation(
                0.0f,
                1.0f,
                0.0f,
                1.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            anim.duration =
                Random().nextInt(501).toLong() //to make duration random number between [0,501)
            viewToAnimate.startAnimation(anim)
            lastPosition = position
        }
    }

    inner class FoodHolder(private val binding: ItemFoodListBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bindViews(food: Food){
            binding.root.setOnClickListener {
                when (binding.ll.visibility) {
                    View.VISIBLE -> {
                        binding.ll.visibility = View.GONE
                    }
                    else -> {
                        binding.ll.visibility = View.VISIBLE
                    }
                }
            }
            Glide.with(context).load(food.url).centerCrop()
                .error(R.drawable.ic_baseline_set_meal_24).into(binding.ivFood)
            binding.tv.text = food.name
            if (food.category == "Liked Meals"){
                binding.iv.setImageResource(R.drawable.ic_baseline_favorite_24)
            }else {
                binding.iv.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }
            binding.iv.setOnClickListener { onClickLikedListener?.onClickLiked(food) }

        }
    }
 interface OnClickLikedListener{
    fun onClickLiked(food: Food)
}

}