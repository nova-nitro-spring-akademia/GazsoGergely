package nnakademia.spring.data;

import nnakademia.spring.domain.Nutrition;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique=true)
    String name;

    @Embedded
    Nutrition nutrition;

    @ManyToMany
    @JoinTable(
        name = "food_ingredient_element",
        joinColumns = @JoinColumn(name = "ingredient_id"),
        inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    Set<FoodEntity> foodEntityList;

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

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }
}
