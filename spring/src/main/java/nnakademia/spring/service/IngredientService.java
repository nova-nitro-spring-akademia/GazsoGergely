package nnakademia.spring.service;

import nnakademia.spring.data.IngredientEntity;
import nnakademia.spring.data.IngredientRepository;
import nnakademia.spring.domain.Ingredient;
import nnakademia.spring.mapper.IngredientEntityMapper;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    IngredientRepository ingredientRepository;

    IngredientEntityMapper ingredientEntityMapper;

    public IngredientService(IngredientRepository ingredientRepository, IngredientEntityMapper ingredientEntityMapper) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientEntityMapper = ingredientEntityMapper;
    }

    public Ingredient save(Ingredient ingredient) {
        IngredientEntity ingredientEntity = ingredientRepository.save(ingredientEntityMapper.toingredientEntity(ingredient));
        return ingredientEntityMapper.fromIngredientEntity(ingredientEntity);
    }
}
