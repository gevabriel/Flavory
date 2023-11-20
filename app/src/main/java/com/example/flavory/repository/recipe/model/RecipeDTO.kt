package com.example.flavory.repository.recipe.model

data class RecipeDTO(
    val id: Long?,
    val name: String,
    val description: String? = "Default",
    val user_ratings: UserRatings?,
    val price: Price?
)

fun RecipeDTO.toModel(): RecipeModel {
    return RecipeModel(
        id = this.id,
        name = this.name,
        description = this.description,
        user_ratings = this.user_ratings,
        price = this.price
    )
}

fun List<RecipeDTO>.toModelList(): List<RecipeModel> =
    this.map { it.toModel() }