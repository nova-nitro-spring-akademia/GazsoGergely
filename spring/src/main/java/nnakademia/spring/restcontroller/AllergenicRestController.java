package nnakademia.spring.restcontroller;

import nnakademia.spring.data.AllergenicEntity;
import nnakademia.spring.domain.*;
import nnakademia.spring.mapper.AllergenicDTOMapper;
import nnakademia.spring.service.AllergenicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public AllergenicDTO getAllergenic(@PathVariable Long id){
        Allergenic allergenic = allergenicService.findById(id);
        return allergenicDTOMapper.toAllergenicDTO(allergenic);
    }


    @GetMapping
    public List<AllergenicDTO> getAllAllergens(){
        List<Allergenic> allergens = allergenicService.findAll();
        return allergenicDTOMapper.toAllergenicDTOList(allergens);
    }

    @DeleteMapping("/{id}")
    public AllergenicDTO deleteAllergen(@PathVariable Long id){
        return allergenicDTOMapper.toAllergenicDTO(allergenicService.deleteById(id));
    }

}