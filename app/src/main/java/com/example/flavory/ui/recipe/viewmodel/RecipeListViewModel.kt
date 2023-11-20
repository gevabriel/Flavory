package com.example.flavory.ui.recipe.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flavory.repository.recipe.RecipeRepository
import com.example.flavory.repository.recipe.model.RecipeModel

class RecipeListViewModel : ViewModel() {
    private val repository = RecipeRepository

    val recipesList: MutableLiveData<List<RecipeModel>> = MutableLiveData()

    fun fetchRecipeData(context: Context) {
        recipesList.value = repository.getRecipes(context)
    }
}