package nnakademia.spring.mapper;

import nnakademia.spring.domain.Allergenic;
import nnakademia.spring.restcontroller.AllergenicDTO;
import org.springframework.stereotype.Component;

@Component
public class AllergenicDTOMapper {

    public AllergenicDTO toAllergenicDTO(Allergenic allergenic){
        AllergenicDTO allergenicDTO = new AllergenicDTO();
        allergenicDTO.setId(allergenic.getId());
        allergenicDTO.setName(allergenic.getName());
        allergenicDTO.setEffect(allergenic.getEffect());
        return allergenicDTO;
    }

    public Allergenic fromAllergenicDTO(AllergenicDTO allergenicDTO){
        Allergenic allergenic = new Allergenic();
        allergenic.setId(allergenicDTO.getId());
        allergenic.setName(allergenicDTO.getName());
        allergenic.setEffect(allergenicDTO.getEffect());
        return allergenic;
    }

}
