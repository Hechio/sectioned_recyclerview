package com.stevehechio.apps.foodmanic.data.model

import java.io.Serializable

/**
 * Created by stevehechio on 8/9/21
 */
data class Food(var name: String, var category: String, var url: String): Serializable

data class FoodCat(var name: String, var list: List<Food>): Serializable