package nnakademia.spring.data;

import nnakademia.spring.domain.Food;

import javax.persistence.*;

@Entity
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    FoodEntity foodEntity;
    String instruction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FoodEntity getFoodEntity() {
        return foodEntity;
    }

    public void setFoodEntity(FoodEntity foodEntity) {
        this.foodEntity = foodEntity;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
