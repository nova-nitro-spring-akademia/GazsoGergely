package nnakademia.spring.service;

import nnakademia.spring.data.AllergenicEntity;
import nnakademia.spring.data.AllergenicRepository;
import nnakademia.spring.domain.Allergenic;
import nnakademia.spring.mapper.AllergenicEntityMapper;
import org.springframework.stereotype.Service;

@Service
public class AllergenicService {

    private AllergenicRepository allergenicRepository;

    private AllergenicEntityMapper allergenicEntityMapper;

    public AllergenicService(AllergenicRepository allergenicRepository, AllergenicEntityMapper allergenicEntityMapper) {
        this.allergenicRepository = allergenicRepository;
        this.allergenicEntityMapper = allergenicEntityMapper;
    }

    public Allergenic save(Allergenic allergenic) {
        AllergenicEntity allergenicEntity = allergenicEntityMapper.toAllergenicEntity(allergenic);
        AllergenicEntity savedEntity = allergenicRepository.save(allergenicEntity);
        return allergenicEntityMapper.fromAllergenicEntity(savedEntity);
    }
}
