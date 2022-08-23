package nnakademia.spring.domain;

public class Carbohydrate extends Nutrition{
    final int kcalsPerGramm=4;

    public Carbohydrate(int quantity){
        this.quantity = quantity;
    }

    @Override
    public int getKcals(){
        return this.quantity * kcalsPerGramm;
    }
}
