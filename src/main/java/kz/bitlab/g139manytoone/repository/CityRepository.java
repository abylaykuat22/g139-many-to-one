package kz.bitlab.g139manytoone.repository;

import kz.bitlab.g139manytoone.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
