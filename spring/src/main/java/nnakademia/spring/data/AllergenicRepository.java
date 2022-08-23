package nnakademia.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergenicRepository extends JpaRepository<AllergenicEntity, Long> {
}
