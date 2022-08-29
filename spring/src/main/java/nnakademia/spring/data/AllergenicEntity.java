package nnakademia.spring.data;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AllergenicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String effect;

    @ManyToMany(mappedBy = "allergens")
    Set<FoodEntity> foodEntitySet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Set<FoodEntity> getFoodEntitySet() {
        return foodEntitySet;
    }

    public void setFoodEntitySet(Set<FoodEntity> foodEntitySet) {
        this.foodEntitySet = foodEntitySet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
