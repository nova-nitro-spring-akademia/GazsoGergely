package nnakademia.spring.domain;

public class Receipe {

    Long id;
    Food food;

    String instruction;

    public Receipe(Long id, Food food, String instruction) {
        this.id = id;
        this.food = food;
        this.instruction = instruction;
    }
}
