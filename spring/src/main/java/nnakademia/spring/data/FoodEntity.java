package nnakademia.spring.data;

import nnakademia.spring.domain.Allergenic;
import nnakademia.spring.domain.Ingredient;

import javax.persistence.*;
import java.util.List;

@Entity
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique = true)
    String name;
//INNNEN KELL FOLYTATNI MANYTOMANY-vel!!!
    List<Ingredient> ingredients;

    List<Allergenic> allergens;
}
