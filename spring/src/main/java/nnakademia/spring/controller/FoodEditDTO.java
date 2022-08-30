package nnakademia.spring.controller;

import nnakademia.spring.domain.Allergenic;
import nnakademia.spring.domain.Ingredient;

import java.util.List;

public class FoodEditDTO {

    Long id;

    String name;

    List<Ingredient> ingredients;

    List<Allergenic> allergens;

    List<Allergenic> allAllergens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Allergenic> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<Allergenic> allergens) {
        this.allergens = allergens;
    }

    public List<Allergenic> getAllAllergens() {
        return allAllergens;
    }

    public void setAllAllergens(List<Allergenic> allAllergens) {
        this.allAllergens = allAllergens;
    }



    public boolean includesAllergenic(Allergenic allergenic){
        return allergens.stream().map(Allergenic::getId).toList().contains(allergenic.getId());
    }

}
