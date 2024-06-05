package com.gukunov.burgershub.domain.uiModel


data class BurgerUIState(
    val burgers: List<BurgerItemUIModel>
)


data class BurgerItemUIModel(
    val desc: String,
    val id: Int,
    val images: List<ImageUIModel>,
    val ingredients: List<IngredientUIModel>,
    val name: String,
    val price: Double,
    val veg: Boolean
)



data class ImageUIModel(
    val lg: String,
    val sm: String
)

data class IngredientUIModel(
    val id: Int,
    val img: String,
    val name: String
)

