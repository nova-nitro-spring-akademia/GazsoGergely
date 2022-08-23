package nnakademia.spring.domain;

import java.util.List;

public class Food {

    Long id;

    List<Ingredient> ingredients;

    List<Allergenic> allergens;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
