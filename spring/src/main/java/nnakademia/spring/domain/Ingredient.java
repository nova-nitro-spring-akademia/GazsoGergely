package nnakademia.spring.domain;

public class Ingredient {

    String name;

    //@Embedded majd az Entity-re kell
    Carbohydrate carbohydrate;

    //@Embedded
    Protein protein;

    //@Embedded
    Fat fat;

    public Ingredient(Carbohydrate carbohydrate, Protein protein, Fat fat){

    }

}
