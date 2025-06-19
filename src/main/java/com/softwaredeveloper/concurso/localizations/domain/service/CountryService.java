package com.softwaredeveloper.concurso.localizations.domain.service;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CountryService {

    List<Country> getAll();
    Country getById(Long countryId);
    Country getByUsername(String countryName);
    Page<Country> getAll(Pageable pageable);
    Country create(Country country);
    Country update(Long countryId, Country request);
    ResponseEntity<?> delete(Long countryId);
}
