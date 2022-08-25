package nnakademia.spring.mapper;

import nnakademia.spring.domain.Carbohydrate;
import nnakademia.spring.domain.Fat;
import nnakademia.spring.domain.Ingredient;
import nnakademia.spring.domain.Protein;
import nnakademia.spring.restcontroller.IngredientDTO;
import org.springframework.stereotype.Component;

@Component
public class IngredientDTOMapper {

    public Ingredient fromIngredientDTO(IngredientDTO ingredientDTO){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDTO.getName());
        ingredient.setCarbohydrate(new Carbohydrate(ingredientDTO.getCarbohydrate()));
        ingredient.setProtein(new Protein(ingredientDTO.getProtein()));
        ingredient.setFat(new Fat(ingredientDTO.getFat()));
        return ingredient;
    }

    public IngredientDTO toIngredientDTO(Ingredient ingredient){
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setName(ingredient.getName());
        ingredientDTO.setCarbohydrate(ingredient.getCarbohydrate().getQuantity());
        ingredientDTO.setProtein(ingredient.getProtein().getQuantity());
        ingredientDTO.setFat(ingredient.getFat().getQuantity());
        return ingredientDTO;
    }
}
