package nnakademia.spring.mapper;

import nnakademia.spring.data.IngredientEntity;
import nnakademia.spring.domain.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientEntityMapper {

    public Ingredient fromIngredientEntity(IngredientEntity ingredientEntity){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientEntity.getId());
        ingredient.setName(ingredientEntity.getName());
        ingredient.setNutrition(ingredientEntity.getNutrition());
        return ingredient;
    }

    public IngredientEntity toingredientEntity(Ingredient ingredient){
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setId(ingredient.getId());
        ingredientEntity.setName(ingredient.getName());
        ingredientEntity.setNutrition(ingredient.getNutrition());
        return ingredientEntity;
    }

}
