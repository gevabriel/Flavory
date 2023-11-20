package com.example.flavory.repository.recipe

import android.content.Context
import android.util.Log
import com.example.flavory.repository.recipe.model.RecipeModel
import com.example.flavory.repository.recipe.model.RecipesDTO
import com.example.flavory.repository.recipe.model.toModelList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

object RecipeRepository {

    private val TAG: String? = RecipeRepository::class.java.canonicalName

    fun getRecipes(context: Context): List<RecipeModel> {
        lateinit var jsonString: String
        try {
            jsonString =
                context.assets.open("recipes.json")
                    .bufferedReader()
                    .use {
                        it.readText()
                    }
        } catch (ioException: IOException) {
            Log.e(TAG, ioException.message.toString())
        }
        val recipesResponse: RecipesDTO =
            Gson().fromJson(jsonString, object : TypeToken<RecipesDTO>() {}.type)
        return recipesResponse.results.toModelList()
    }
}