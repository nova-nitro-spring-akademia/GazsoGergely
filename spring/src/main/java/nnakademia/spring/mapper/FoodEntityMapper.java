package nnakademia.spring.mapper;

import nnakademia.spring.data.FoodEntity;
import nnakademia.spring.data.IngredientEntity;
import nnakademia.spring.domain.Food;
import nnakademia.spring.domain.Ingredient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FoodEntityMapper {

    IngredientEntityMapper ingredientEntityMapper;

    public FoodEntityMapper(IngredientEntityMapper ingredientEntityMapper) {
        this.ingredientEntityMapper = ingredientEntityMapper;
    }

    public FoodEntity toFoodEntity(Food food){
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setName(food.getName());

//        List<Ingredient> --> Set<SetIngredientEntity>
        Set<IngredientEntity> ingredientEntitySet = food.getIngredients()
                .stream()
                .map(ingredientEntityMapper::toingredientEntity)
                .collect(Collectors.toSet());

        foodEntity.setIngredients(ingredientEntitySet);

        return foodEntity;
    }

    public Food fromFoodEntity(FoodEntity foodEntity) {

        Food food = new Food();
        food.setName(foodEntity.getName());
        List<Ingredient> ingredientList = foodEntity.getIngredients()
                .stream()
                .map(ingredientEntityMapper::fromIngredientEntity)
                .collect(Collectors.toList());

        food.setIngredients(ingredientList);
        food.setId(foodEntity.getId());

        return food;

    }
}
