package nnakademia.spring.data;

import nnakademia.spring.domain.Allergenic;
import nnakademia.spring.domain.Ingredient;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    @ManyToMany
    @JoinTable(
            name = "food_ingredient_element",
            joinColumns = @JoinColumn(name = "food_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    Set<IngredientEntity> ingredients;

//    List<AllergenicEntity> allergens;


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

    public Set<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }
}
