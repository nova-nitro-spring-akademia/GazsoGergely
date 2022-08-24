package nnakademia.spring.mapper;

import nnakademia.spring.data.AllergenicEntity;
import nnakademia.spring.domain.Allergenic;
import org.springframework.stereotype.Component;

@Component
public class AllergenicEntityMapper {

    public AllergenicEntity toAllergenicEntity(Allergenic allergenic) {
        AllergenicEntity allergenicEntity = new AllergenicEntity();
        allergenicEntity.setId(allergenic.getId());
        allergenicEntity.setName(allergenic.getName());
        allergenicEntity.setEffect(allergenic.getEffect());
        return allergenicEntity;
    }

    public Allergenic fromAllergenicEntity(AllergenicEntity allergenicEntity){
        Allergenic allergenic = new Allergenic();
        allergenic.setId(allergenicEntity.getId());
        allergenic.setName(allergenicEntity.getName());
        allergenic.setEffect(allergenicEntity.getEffect());
        return allergenic;
    }
}
