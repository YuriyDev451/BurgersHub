package com.gukunov.burgershub.domain.uiModel.mapper

import com.gukunov.burgershub.common.BaseMapper
import com.gukunov.burgershub.domain.entity.BurgerItem
import com.gukunov.burgershub.domain.entity.BurgerResponse
import com.gukunov.burgershub.domain.uiModel.BurgerItemUIModel
import com.gukunov.burgershub.domain.uiModel.BurgerUIState
import com.gukunov.burgershub.domain.uiModel.ImageUIModel
import com.gukunov.burgershub.domain.uiModel.IngredientUIModel
import javax.inject.Inject

class BurgersToUIStateMapper @Inject constructor(): BaseMapper<List<BurgerItem>, BurgerUIState> {
    override fun map(input: List<BurgerItem>): BurgerUIState {
        return BurgerUIState( burgers = input.map { burger->
            BurgerItemUIModel(
                desc = burger.desc?:"",
                id = burger.id ?: 0,
                images = burger.images.map {image->
                    ImageUIModel(
                        lg = image.lg ?: "",
                        sm = image.lg ?: ""
                    )
                },
                ingredients = burger.ingredients.map {ingredient->
                    IngredientUIModel(
                        id = ingredient.id?: 0,
                        img = ingredient.img?: "",
                        name = ingredient.name?:""
                    )
                },
                name = burger.name?:"",
                price = burger.price?: 0.0,
                veg = burger.veg?: false,
            )

        }

        )
    }
}