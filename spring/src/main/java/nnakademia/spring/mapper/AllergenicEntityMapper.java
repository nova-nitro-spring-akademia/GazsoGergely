package nnakademia.spring.mapper;

import nnakademia.spring.data.AllergenicEntity;
import nnakademia.spring.domain.Allergenic;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllergenicEntityMapper {

    public AllergenicEntity toAllergenicEntity(Allergenic allergenic) {
        AllergenicEntity allergenicEntity = new AllergenicEntity();
        allergenicEntity.setName(allergenic.getName());
        allergenicEntity.setEffect(allergenic.getEffect());
        return allergenicEntity;
    }

    public Allergenic fromAllergenicEntity(AllergenicEntity allergenicEntity){
        Allergenic allergenic = new Allergenic();
        allergenic.setName(allergenicEntity.getName());
        allergenic.setEffect(allergenicEntity.getEffect());
        return allergenic;
    }


    public List<Allergenic> fromAllergenicEntityList(List<AllergenicEntity> allergenicEntities) {
        return allergenicEntities.stream().map(this::fromAllergenicEntity).toList();
    }
}
