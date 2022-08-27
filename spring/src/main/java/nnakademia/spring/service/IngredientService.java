package nnakademia.spring.service;

import nnakademia.spring.data.AllergenicEntity;
import nnakademia.spring.data.IngredientEntity;
import nnakademia.spring.data.IngredientRepository;
import nnakademia.spring.domain.Allergenic;
import nnakademia.spring.domain.Ingredient;
import nnakademia.spring.mapper.IngredientEntityMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    public List<Ingredient> findAll() {
        List<IngredientEntity> ingredientEntities = ingredientRepository
                .findAll();
        return ingredientEntityMapper.fromIngredientEntityList(ingredientEntities);
    }

    public Ingredient findById(Long id){
        IngredientEntity ingredientEntity = ingredientRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ingredientEntityMapper.fromIngredientEntity(ingredientEntity);
    }



}
