package nnakademia.spring.domain;

public class Protein extends Nutrition{
    final int kcalsPerGramm=4;

    public Protein(int quantity){
        this.quantity = quantity;
    }

    @Override
    public int getKcals(){
        return this.quantity * kcalsPerGramm;
    }
}
