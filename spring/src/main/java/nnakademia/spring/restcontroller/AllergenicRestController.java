package nnakademia.spring.restcontroller;

import nnakademia.spring.domain.Allergenic;
import nnakademia.spring.mapper.AllergenicDTOMapper;
import nnakademia.spring.service.AllergenicService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/allergens")
public class AllergenicRestController {

    AllergenicService allergenicService;

    AllergenicDTOMapper allergenicDTOMapper;

    public AllergenicRestController(AllergenicService allergenicService, AllergenicDTOMapper allergenicDTOMapper) {
        this.allergenicService = allergenicService;
        this.allergenicDTOMapper = allergenicDTOMapper;
    }

    @PostMapping
    public Allergenic postAllergenic(@RequestBody AllergenicDTO allergenicDTO){
        Allergenic allergenic = allergenicDTOMapper.fromAllergenicDTO(allergenicDTO);
        Allergenic allergenicSaved = allergenicService.sa
    }

}