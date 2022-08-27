package nnakademia.spring.controller;

import nnakademia.spring.domain.Allergenic;
import nnakademia.spring.domain.Food;
import nnakademia.spring.domain.Ingredient;
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

import java.util.Arrays;
import java.util.List;

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

        FoodFormData foodFormData = new FoodFormData();

        foodFormData.setIngredients(ingredientService.findAll());
        foodFormData.setIngredientIdArray(new Long[foodPropertiesFromForm.getNumOfIngredients()]);

        foodFormData.setAllergens(allergenicService.findAll());
        foodFormData.setAllergensArray(new String[foodPropertiesFromForm.getNumOfAllergens()]);

        model.addAttribute(foodFormData);

        return "food-form";
    }

    @PostMapping("/saveFood")
    public String saveFood(@ModelAttribute FoodFormData foodFormData){
        List<Allergenic> chosenAllergenicList = List.of(foodFormData.getAllergensArray())
                .stream()
                .map(a -> allergenicService.findById(a))
                .toList();
        foodFormData.setChosenAllergens(chosenAllergenicList);

        List<Ingredient> chosenIngredientList = List.of(foodFormData.getIngredientIdArray())
                .stream()
                .map(a -> ingredientService.findById(a))
                .toList();
        foodFormData.setChosenIngredients(chosenIngredientList);



        System.out.println("Allergen List:");
        foodFormData.getChosenAllergens().forEach(a -> System.out.println("name: " + a.getName() + ", effect: " + a.getEffect()));

        System.out.println("Ingredient List:");
        foodFormData.getChosenIngredients().forEach(a -> System.out.println("name: " + a.getName() + " " + a.getNutrition()));

        return "home";
    }



}
