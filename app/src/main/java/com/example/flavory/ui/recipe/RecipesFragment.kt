package com.example.flavory.ui.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.flavory.R
import com.example.flavory.activities.MainActivity
import com.example.flavory.repository.recipe.RecipeRepository
import com.example.flavory.ui.recipe.viewmodel.RecipeListViewModel

class RecipesFragment : Fragment() {

    companion object {
        private val TAG: String? = RecipesFragment::class.java.canonicalName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        context?.let {
//            val recipes = RecipeRepository.getRecipes(it)
//            Log.d(TAG, "Number of recipes = " + recipes[1].user_ratings)
//      }

        val viewModel = ViewModelProvider(this).get(RecipeListViewModel::class.java)

        context?.let {
            viewModel.fetchRecipeData(it)
        }

        viewModel.recipesList.observe(viewLifecycleOwner) { recipes ->
            for (recipe in recipes) {
                Log.d("RecipeData", "Recipe description: ${recipe.price}")
                //Log.d("RecipeData", "Recipe Name: ${recipe.name}")
               // Log.d("RecipeData", "Recipe ratings: ${recipe.user_ratings}")

            }
        }
    }
}