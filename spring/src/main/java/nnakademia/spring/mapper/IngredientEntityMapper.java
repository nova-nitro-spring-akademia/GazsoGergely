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
        ingredient.setCarbohydrate(ingredientEntity.getCarbohydrate());
        ingredient.setProtein(ingredientEntity.getProtein());
        ingredient.setFat(ingredientEntity.getFat());
        return ingredient;
    }

    public IngredientEntity toingredientEntity(Ingredient ingredient){
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setId(ingredient.getId());
        ingredientEntity.setName(ingredient.getName());
        ingredientEntity.setCarbohydrate(ingredient.getCarbohydrate());
        ingredientEntity.setProtein(ingredient.getProtein());
        ingredientEntity.setFat(ingredient.getFat());
        return ingredientEntity;
    }

}
