package nnakademia.spring.controller;

import nnakademia.spring.domain.Allergenic;
import nnakademia.spring.domain.Ingredient;
import nnakademia.spring.restcontroller.AllergenicDTO;
import nnakademia.spring.restcontroller.IngredientDTO;

import java.util.List;

public class FoodFormData {

    List<String> ingredientsNames;

    List<String> allergensNames;

    public List<String> getIngredientsNames() {
        return ingredientsNames;
    }

    public void setIngredientsNames(List<String> ingredientsNames) {
        this.ingredientsNames = ingredientsNames;
    }

    public List<String> getAllergensNames() {
        return allergensNames;
    }

    public void setAllergensNames(List<String> allergensNames) {
        this.allergensNames = allergensNames;
    }
}
