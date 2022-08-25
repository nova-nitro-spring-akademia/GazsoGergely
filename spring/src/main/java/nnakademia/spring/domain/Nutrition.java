package nnakademia.spring.domain;

abstract class Nutrition {
    protected int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getKcals(){
        return quantity * 1;
    }
}
