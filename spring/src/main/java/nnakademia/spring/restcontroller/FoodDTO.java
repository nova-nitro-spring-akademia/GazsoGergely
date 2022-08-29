package nnakademia.spring.restcontroller;

import nnakademia.spring.domain.Allergenic;
import nnakademia.spring.domain.Ingredient;
import nnakademia.spring.mapper.FoodDTOMapper;

import java.util.List;

public class FoodDTO {

    Long id;

    String name;

    List<Ingredient> ingredients;

    List<Allergenic> allergens;


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

    public String allergensToString(){
        List<String >allergenNameList = this.allergens.stream().map(a -> a.getName()).toList();
        return String.join(", ", allergenNameList);
    }

    public String ingredientsToString(){
        List<String >ingredientsNameList = this.ingredients.stream().map(a -> a.getName()).toList();
        return String.join(", ", ingredientsNameList);
    }

}