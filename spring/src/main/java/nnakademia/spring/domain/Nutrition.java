package nnakademia.spring.domain;

abstract class Nutrition {
    protected int quantity;

    public int getKcals(){
        return quantity * 1;
    }
}
