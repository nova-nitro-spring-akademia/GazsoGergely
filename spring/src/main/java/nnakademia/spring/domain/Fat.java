package nnakademia.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Transient;

public class Fat extends Nutrition{
    @Transient
    final int kcalsPerGramm=9;

    public Fat(int quantity){
        this.quantity = quantity;
    }

    @Override
    public int getKcals(){
        return this.quantity * kcalsPerGramm;
    }
}
