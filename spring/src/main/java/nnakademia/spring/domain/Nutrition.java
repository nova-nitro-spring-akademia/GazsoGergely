package nnakademia.spring.domain;

public class Nutrition {

    int carbohydrate;
    int protein;
    int fat;

    public Nutrition() {
    }

    public Nutrition(int carbohydrate, int protein, int fat) {
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

}
