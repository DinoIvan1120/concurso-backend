package com.softwaredeveloper.concurso.localizations.domain.persistence;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByCityName(String cityName);
}
