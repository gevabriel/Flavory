package com.example.flavory.repository.recipe.model

data class RecipeModel(
    val id: Long?,
    val name: String,
    val description: String?,
    val user_ratings: UserRatings?,
    val price: Price?
)

data class UserRatings(
    val count_positive: Long?,
    val score: Double?,
    val count_negative: Long?
)

data class Price(
    val consumption_portion: Int?,
    val total: Int?,
    val updated_at: String?,
    val portion: Int?,
    val consumption_total: Int?
)