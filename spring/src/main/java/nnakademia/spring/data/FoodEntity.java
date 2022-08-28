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

    @Column(unique = true)
    String name;

    @ManyToMany(mappedBy = "foodEntityList")
    Set<IngredientEntity> ingredients;

//    List<AllergenicEntity> allergens;
}
