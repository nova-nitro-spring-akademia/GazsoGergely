package nnakademia.spring.domain;

public class Recipe {

    Long id;
    Food food;
    String instruction;

    public Recipe(Long id, Food food, String instruction) {
        this.id = id;
        this.food = food;
        this.instruction = instruction;
    }
}
