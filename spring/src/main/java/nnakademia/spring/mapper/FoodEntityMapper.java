package nnakademia.spring.mapper;

import nnakademia.spring.data.AllergenicEntity;
import nnakademia.spring.data.FoodEntity;
import nnakademia.spring.data.IngredientEntity;
import nnakademia.spring.domain.Allergenic;
import nnakademia.spring.domain.Food;
import nnakademia.spring.domain.Ingredient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FoodEntityMapper {

    IngredientEntityMapper ingredientEntityMapper;

    AllergenicEntityMapper allergenicEntityMapper;

    public FoodEntityMapper(IngredientEntityMapper ingredientEntityMapper, AllergenicEntityMapper allergenicEntityMapper) {
        this.ingredientEntityMapper = ingredientEntityMapper;
        this.allergenicEntityMapper = allergenicEntityMapper;
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

        //        List<Allergenic> --> Set<AllergenicEntity>
        Set<AllergenicEntity> allergenicEntitySet =food.getAllergens()
                .stream()
                .map(allergenicEntityMapper::toAllergenicEntity)
                .collect(Collectors.toSet());
        foodEntity.setAllergens(allergenicEntitySet);

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

        List<Allergenic> allergenicList = foodEntity.getAllergens()
                .stream()
                .map(allergenicEntityMapper::fromAllergenicEntity)
                .toList();
        food.setAllergens(allergenicList);

        food.setId(foodEntity.getId());

        return food;

    }

    public List<Food> fromFoodEntityList(List<FoodEntity> foodEntityList) {
        List<Food> foodList = foodEntityList
                .stream()
                .map(this::fromFoodEntity)
                .toList();
        return foodList;
    }
}
