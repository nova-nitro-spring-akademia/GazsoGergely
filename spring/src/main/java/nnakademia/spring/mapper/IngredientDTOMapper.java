package nnakademia.spring.mapper;

import nnakademia.spring.domain.*;
import nnakademia.spring.restcontroller.IngredientDTO;
import org.springframework.stereotype.Component;

@Component
public class IngredientDTOMapper {

    public Ingredient fromIngredientDTO(IngredientDTO ingredientDTO){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDTO.getName().toLowerCase());
        ingredient.setNutrition(new Nutrition(
                ingredientDTO.getCarbohydrate(),
                ingredientDTO.getProtein(),
                ingredientDTO.getFat()
        ));
        return ingredient;
    }

    public IngredientDTO toIngredientDTO(Ingredient ingredient){
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setName(ingredient.getName());
        ingredientDTO.setCarbohydrate(ingredient.getNutrition().getCarbohydrate());
        ingredientDTO.setProtein(ingredient.getNutrition().getProtein());
        ingredientDTO.setFat(ingredient.getNutrition().getFat());
        return ingredientDTO;
    }
}
