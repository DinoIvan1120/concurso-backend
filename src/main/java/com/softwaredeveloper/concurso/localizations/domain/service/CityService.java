package com.softwaredeveloper.concurso.localizations.domain.service;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CityService {

    List<City> getAllCities();
    City getById(Long cityId);
    City getByUsername(String cityName);
    Page<City> getAllCitiesPage(Pageable pageable);
    City create(City city, Long countryId);
    City update(City city, Long cityId);
    ResponseEntity<?> delete(Long cityId);
}
