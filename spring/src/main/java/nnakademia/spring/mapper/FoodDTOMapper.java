package nnakademia.spring.mapper;

import nnakademia.spring.domain.Food;
import nnakademia.spring.restcontroller.FoodDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodDTOMapper {

    public Food fromFoodDTO(FoodDTO foodDTO){
        Food food = new Food();
        food.setName(foodDTO.getName());
        food.setIngredients(foodDTO.getIngredients());
        food.setAllergens(foodDTO.getAllergens());
        return  food;
    }

    public FoodDTO toFoodDTO(Food food){
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setId(food.getId());
        foodDTO.setName(food.getName());
        foodDTO.setAllergens(food.getAllergens());
        foodDTO.setIngredients(food.getIngredients());
        return foodDTO;
    }

    public List<FoodDTO> toFoodDTOList(List<Food> foodList) {
        return foodList
                .stream()
                .map(this::toFoodDTO)
                .toList();
    }
}
