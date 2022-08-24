package nnakademia.spring.restcontroller;

import nnakademia.spring.domain.*;
import nnakademia.spring.mapper.AllergenicDTOMapper;
import nnakademia.spring.service.AllergenicService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/allergens")
public class AllergenicRestController {

    AllergenicService allergenicService;

    AllergenicDTOMapper allergenicDTOMapper;

    public AllergenicRestController(AllergenicService allergenicService, AllergenicDTOMapper allergenicDTOMapper) {
        this.allergenicService = allergenicService;
        this.allergenicDTOMapper = allergenicDTOMapper;
    }

    @PostMapping
    public AllergenicDTO postAllergenic(@RequestBody AllergenicDTO allergenicDTO){
        Allergenic allergenic = allergenicDTOMapper.fromAllergenicDTO(allergenicDTO);
        Allergenic allergenicSaved = allergenicService.save(allergenic);
        return allergenicDTOMapper.toAllergenicDTO(allergenicSaved);
    }

    @GetMapping("/getsamplerecipe")
    public Recipe getSampleRecipe(){
        Carbohydrate carbohydrate = new Carbohydrate();
        Ingredient ingredient = new Ingredient();
        Allergenic allergenic = new Allergenic();
        Food food = new Food();

        Recipe recipe = new Recipe(new Long(1), food, "ask your Mom for instructions");

        return null;
    }

}