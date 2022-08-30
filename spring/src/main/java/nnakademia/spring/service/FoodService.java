package nnakademia.spring.service;

import nnakademia.spring.data.FoodEntity;
import nnakademia.spring.data.FoodRepository;
import nnakademia.spring.domain.Food;
import nnakademia.spring.mapper.FoodEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodService {

    FoodRepository foodRepository;

    FoodEntityMapper foodEntityMapper;

    public FoodService(FoodRepository foodRepository, FoodEntityMapper foodEntityMapper) {
        this.foodRepository = foodRepository;
        this.foodEntityMapper = foodEntityMapper;
    }

    public Food save(Food newFood) {
        FoodEntity foodEntity = foodEntityMapper.toFoodEntity(newFood);
        FoodEntity savedFoodEntity = foodRepository.save(foodEntity);
        Food savedFood = foodEntityMapper.fromFoodEntity(savedFoodEntity);
        return savedFood;
    }

    public List<Food> findAll() {
        List<FoodEntity> foodEntityList = foodRepository.findAll();
        return foodEntityMapper.fromFoodEntityList(foodEntityList);
    }

    public Food findById(Long id) {
        return foodEntityMapper.fromFoodEntity(foodRepository.findById(id).orElseThrow());
    }
}
