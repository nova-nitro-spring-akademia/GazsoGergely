package nnakademia.spring.domain;

public class Fat extends Nutrition{
    final int kcalsPerGramm=9;

    public Fat(int quantity){
        this.quantity = quantity;
    }

    @Override
    public int getKcals(){
        return this.quantity * kcalsPerGramm;
    }
}
