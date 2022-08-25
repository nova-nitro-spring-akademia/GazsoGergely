package nnakademia.spring.controller;

import nnakademia.spring.mapper.AllergenicDTOMapper;
import nnakademia.spring.restcontroller.AllergenicDTO;
import nnakademia.spring.restcontroller.IngredientDTO;
import nnakademia.spring.service.AllergenicService;
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

    public MainController(AllergenicDTOMapper allergenicDTOMapper, AllergenicService allergenicService) {
        this.allergenicDTOMapper = allergenicDTOMapper;
        this.allergenicService = allergenicService;
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
    public String saveEmployee(@ModelAttribute("allergenicDTO") AllergenicDTO allergenicDTO) {
        allergenicService.save(allergenicDTOMapper.fromAllergenicDTO(allergenicDTO));
        return "redirect:/home";
    }

    @GetMapping("/addingredientform")
        public String addIngredientForm(Model model){
            IngredientDTO ingredientDTO = new IngredientDTO();
            model.addAttribute("ingredientDTO", ingredientDTO);
            return "ingredient-form";
        }

}
