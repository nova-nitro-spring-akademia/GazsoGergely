package nnakademia.spring.controller;

import nnakademia.spring.domain.Food;
import nnakademia.spring.mapper.AllergenicDTOMapper;
import nnakademia.spring.mapper.FoodDTOMapper;
import nnakademia.spring.mapper.IngredientDTOMapper;
import nnakademia.spring.restcontroller.AllergenicDTO;
import nnakademia.spring.restcontroller.FoodDTO;
import nnakademia.spring.restcontroller.IngredientDTO;
import nnakademia.spring.service.AllergenicService;
import nnakademia.spring.service.FoodService;
import nnakademia.spring.service.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {

    AllergenicDTOMapper allergenicDTOMapper;

    AllergenicService allergenicService;

    IngredientDTOMapper ingredientDTOMapper;

    IngredientService ingredientService;

    FoodDTOMapper foodDTOMapper;

    FoodService foodService;

    public MainController(AllergenicDTOMapper allergenicDTOMapper, AllergenicService allergenicService, IngredientDTOMapper ingredientDTOMapper, IngredientService ingredientService, FoodDTOMapper foodDTOMapper, FoodService foodService) {
        this.allergenicDTOMapper = allergenicDTOMapper;
        this.allergenicService = allergenicService;
        this.ingredientDTOMapper = ingredientDTOMapper;
        this.ingredientService = ingredientService;
        this.foodDTOMapper = foodDTOMapper;
        this.foodService = foodService;
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/addallergenicform")
    public String addAllergenicForm(Model model){
        AllergenicDTO allergenicDTO = new AllergenicDTO();
        model.addAttribute("allergenicDTO",allergenicDTO);
        return "allergenic-form";
    }

    @PostMapping("/saveallergenic")
    public String saveAlergenic(@ModelAttribute("allergenicDTO") AllergenicDTO allergenicDTO) {
        allergenicService.save(allergenicDTOMapper.fromAllergenicDTO(allergenicDTO));
        return "redirect:/home";
    }

    @GetMapping("/addingredientform")
        public String addIngredientForm(Model model){
            IngredientDTO ingredientDTO = new IngredientDTO();
            model.addAttribute("ingredientDTO", ingredientDTO);
            return "ingredient-form";
        }

    @PostMapping("/saveingredient")
    public String saveIngredient(@ModelAttribute("ingredientDTO") IngredientDTO ingredientDTO) {
        ingredientService.save(ingredientDTOMapper.fromIngredientDTO(ingredientDTO));
        return "redirect:/home";
    }

    @GetMapping("/addfoodpropertiesform")
    public String addFoodPropertiesForm(Model model){
        FoodProperties foodProperties = new FoodProperties();
        model.addAttribute("foodProperties",foodProperties);
        return "food-properties-form";
    }

    @PostMapping("/addfoodform")
    public String addFoodForm(
            @ModelAttribute("foodProperties") FoodProperties foodPropertiesFromForm,
            Model model){

//        FoodProperties foodProperties = new FoodProperties();
//        foodProperties.setNumOfAllergens(foodPropertiesFromForm.getNumOfAllergens());
//        foodProperties.setNumOfIngredients(foodPropertiesFromForm.getNumOfIngredients());
//        model.addAttribute("foodProperties", foodProperties);

        return "food-form";
    }



}
