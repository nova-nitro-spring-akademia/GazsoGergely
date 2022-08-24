package nnakademia.spring.service;

import nnakademia.spring.data.AllergenicEntity;
import nnakademia.spring.data.AllergenicRepository;
import nnakademia.spring.domain.Allergenic;
import nnakademia.spring.mapper.AllergenicEntityMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    public Allergenic findById(String name) {
        AllergenicEntity allergenicEntity = allergenicRepository
                .findById(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
        return  allergenicEntityMapper.fromAllergenicEntity(allergenicEntity);
    }

    public List<Allergenic> findAll() {
        List<AllergenicEntity> allergenicEntities =  allergenicRepository
                .findAll();
        return allergenicEntityMapper.fromAllergenicEntityList(allergenicEntities);
    }

    public Allergenic deleteById(String name) {
        Allergenic deletedAllergenic = findById(name);
        allergenicRepository.deleteById(name);
        return deletedAllergenic;
    }
}
