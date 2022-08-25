package nnakademia.spring.controller;

import org.springframework.stereotype.Component;

public class FoodProperties {
    int numOfIngredients;
    int numOfAllergens;

    public int getNumOfIngredients() {
        return numOfIngredients;
    }

    public void setNumOfIngredients(int numOfIngredients) {
        this.numOfIngredients = numOfIngredients;
    }

    public int getNumOfAllergens() {
        return numOfAllergens;
    }

    public void setNumOfAllergens(int numOfAllergens) {
        this.numOfAllergens = numOfAllergens;
    }
}
