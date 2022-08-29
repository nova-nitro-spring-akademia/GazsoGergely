package nnakademia.spring.mapper;

import nnakademia.spring.domain.Allergenic;
import nnakademia.spring.restcontroller.AllergenicDTO;
import org.springframework.stereotype.Component;

import java.util.List;

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
        allergenic.setName(allergenicDTO.getName().toLowerCase());
        allergenic.setEffect(allergenicDTO.getEffect());
        return allergenic;
    }

    public List<AllergenicDTO> toAllergenicDTOList(List<Allergenic> allergens) {
        return allergens.stream().map(this::toAllergenicDTO).toList();
    }
}
