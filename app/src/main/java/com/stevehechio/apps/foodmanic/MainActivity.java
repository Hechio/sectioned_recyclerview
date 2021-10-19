package com.stevehechio.apps.foodmanic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.stevehechio.apps.foodmanic.adapters.CategoryAdapter;
import com.stevehechio.apps.foodmanic.data.model.Food;
import com.stevehechio.apps.foodmanic.data.model.FoodCat;
import com.stevehechio.apps.foodmanic.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<FoodCat> arrayList = new ArrayList<>();
    private List<Food> liked = new ArrayList<>();
    private FoodCat foodCatLiked;
    CategoryAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpViews();
    }

    private void setUpViews() {
        Food food = new Food("Chicken Chillie Cooked Samosas","Liked Meals",
                "https://images.unsplash.com/photo-1612392061787-2d078b3e573c?ixid=MnwxMjA3fDF8MHxzZWFyY2h8Mjh8fGZvb2R8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=400&q=60");

        Food food1 = new Food("Beef Chillie Cooked Samosas","Popular Meals",
                "https://images.unsplash.com/photo-1540189549336-e6e99c3679fe?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjR8fGZvb2R8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=400&q=60");
        Food food2 = new Food("Chicken Cooked Samosas","Liked Meals",
                "https://images.unsplash.com/photo-1529042410759-befb1204b468?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTZ8fGZvb2R8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=400&q=60");

        Food food3 = new Food("Vegetable Cooked Samosas","Popular Meals",
                "https://images.unsplash.com/photo-1484723091739-30a097e8f929?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTF8fGZvb2R8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=400&q=60");
       Food food31 = new Food("Vegetable Cooked Samosas","Popular Meals",
                "https://images.unsplash.com/photo-1484723091739-30a097e8f929?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTF8fGZvb2R8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=400&q=60");
       Food food32 = new Food("Vegetable Cooked Samosas","Popular Meals",
                "https://images.unsplash.com/photo-1484723091739-30a097e8f929?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTF8fGZvb2R8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=400&q=60");
       Food food33 = new Food("Vegetable Cooked Samosas","Popular Meals",
                "https://images.unsplash.com/photo-1484723091739-30a097e8f929?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTF8fGZvb2R8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=400&q=60");

        Food food4 = new Food("Vegetable Samosas","Liked Meals",
                "https://images.unsplash.com/photo-1627662168806-efa33a7cda86?ixid=MnwxMjA3fDF8MHxzZWFyY2h8OHx8Zm9vZHxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=400&q=60");

        Food food5 = new Food("Beef Precooked Samosas","Other Meals",
                "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8Zm9vZHxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=400&q=60");
        Food food6 = new Food("Chicken Precooked Samosas","Liked Meals",
                "https://firebasestorage.googleapis.com/v0/b/vellofood.appspot.com/o/COOKED%20SAMOSAS.jpg?alt=media&token=f3931796-08b5-4feb-9173-1d6210dca4be");

        Food food7 = new Food("Beef Cooked Samosas","Other Meals",
                "https://images.unsplash.com/photo-1482049016688-2d3e1b311543?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8Zm9vZHxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=400&q=60");


        liked.add(food);
        liked.add(food2);
        liked.add(food4);
        liked.add(food6);
        List<Food> popular= new ArrayList<>();
        popular.add(food1);
        popular.add(food3);
        popular.add(food31);
        popular.add(food32);
        popular.add(food33);
        List<Food> other = new ArrayList<>();
        other.add(food5);
        other.add(food7);


        foodCatLiked = new FoodCat("Liked Meals",liked);
        FoodCat foodCatPopular = new FoodCat("Popular Meals",popular);
        FoodCat foodCat = new FoodCat("Other Meals",other);


        arrayList.add(foodCatLiked);
        arrayList.add(foodCatPopular);
        arrayList.add(foodCat);
        binding.rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new CategoryAdapter(getApplicationContext());
        adapter.setMyFoodList(arrayList);
        binding.rv.setAdapter(adapter);
        adapter.setOnUpDateData(this::onUpDateData);
        adapter.setOnUpDateData((food8, foodCat1) -> {


        });
    }

    private void onUpDateData(Food food, FoodCat foodCat) {
        liked.add(food);
        arrayList.remove(foodCatLiked);
        liked.add(food);
        foodCatLiked = new FoodCat("Liked Meals",liked);
        adapter.setFoodList(arrayList);
    }
}