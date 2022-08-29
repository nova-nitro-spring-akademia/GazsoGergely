package nnakademia.spring.restcontroller;

import nnakademia.spring.domain.Food;
import nnakademia.spring.mapper.FoodDTOMapper;
import nnakademia.spring.service.FoodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodRestController {

    FoodService foodService;

    FoodDTOMapper foodDTOMapper;

    public FoodRestController(FoodService foodService, FoodDTOMapper foodDTOMapper) {
        this.foodService = foodService;
        this.foodDTOMapper = foodDTOMapper;
    }

    @GetMapping
    public List<FoodDTO> getAllFoods(){
        List<Food> foodList = foodService.findAll();
        return foodDTOMapper.toFoodDTOList(foodList);
    }
}
