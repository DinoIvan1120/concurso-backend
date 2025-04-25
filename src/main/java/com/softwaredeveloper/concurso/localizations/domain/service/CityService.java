package com.softwaredeveloper.concurso.localizations.domain.service;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.City;
import com.softwaredeveloper.concurso.localizations.domain.model.entity.Country;
import com.softwaredeveloper.concurso.localizations.dto.CityResource;
import com.softwaredeveloper.concurso.localizations.dto.CreateCityResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CityService {

    List<City> getAllCities();
    City getById(Long cityId);
    City getByUsername(String cityName);
    Page<City> getAllCitiesPage(Pageable pageable);
    CityResource create(CreateCityResource resource);
    City update(Long cityId, City city);
    ResponseEntity<?> delete(Long cityId);
}
