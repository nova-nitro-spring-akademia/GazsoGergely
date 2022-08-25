package nnakademia.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Transient;

public class Carbohydrate extends Nutrition{
    @Transient
    final int kcalsPerGramm=4;

    public Carbohydrate(int quantity){
        this.quantity = quantity;
    }

    @Override
    public int getKcals(){
        return this.quantity * kcalsPerGramm;
    }
}
