package nnakademia.spring.controller;

import nnakademia.spring.domain.Allergenic;
import nnakademia.spring.domain.Ingredient;
import nnakademia.spring.service.AllergenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

public class FoodFormData {

    List<Ingredient> ingredients;

    List<Ingredient> chosenIngredients;

    String[] allergensArray;

    Long[] IngredientIdArray;

    List<Allergenic> allergens;

    List<Allergenic> chosenAllergens;


    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredient> getChosenIngredients() {
        return chosenIngredients;
    }

    public void setChosenIngredients(List<Ingredient> chosenIngredients) {
        this.chosenIngredients = chosenIngredients;
    }

    public List<Allergenic> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<Allergenic> allergens) {
        this.allergens = allergens;
    }

    public List<Allergenic> getChosenAllergens() {
        return chosenAllergens;
    }

    public void setChosenAllergens(List<Allergenic> chosenAllergens) {
        this.chosenAllergens = chosenAllergens;
    }

    public String[] getAllergensArray() {
        return allergensArray;
    }

    public void setAllergensArray(String[] allergensArray) {
        this.allergensArray = allergensArray;
    }

    public Long[] getIngredientIdArray() {
        return IngredientIdArray;
    }

    public void setIngredientIdArray(Long[] ingredientIdArray) {
        IngredientIdArray = ingredientIdArray;
    }
}
