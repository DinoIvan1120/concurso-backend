package com.softwaredeveloper.concurso.localizations.service;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.Country;
import com.softwaredeveloper.concurso.localizations.domain.persistence.CountryRepository;
import com.softwaredeveloper.concurso.localizations.domain.service.CountryService;
import com.softwaredeveloper.concurso.shared.exception.ResourceNotFoundException;
import com.softwaredeveloper.concurso.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;

@Service
public class CountryServiceImpl implements CountryService {

    private static final String ENTITY_NAME = "Country";
    private final CountryRepository countryRepository;

    private final Validator validator;

    public CountryServiceImpl(CountryRepository repository, Validator validator) {
        this.countryRepository = repository;
        this.validator = validator;
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getById(Long countryId) {
        return countryRepository.findById(countryId)
                        .orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME,countryId));
    }

    @Override
    public Country getByUsername(String countryName) {
        return countryRepository.findByCountryName(countryName);
    }

    @Override
    public Page<Country> getAll(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    @Override
    public Country create(Country country) {
        Set<ConstraintViolation<Country>> violations = validator.validate(country);

        if(!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY_NAME,violations);
        }
        try {
            return countryRepository.save(country);
        }catch (Exception e) {
            throw new ResourceNotFoundException(ENTITY_NAME,e);
        }

    }

    @Override
    public Country update(Long countryId, Country request) {
        Set<ConstraintViolation<Country>> violations = validator.validate(request);

        if(!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY_NAME,violations);
        }

        try {
            return countryRepository.findById(countryId)
                    .map(country -> {
                        country.setCountryName(request.getCountryName());
                        return countryRepository.save(country);
                    })
                    .orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, countryId));

        }catch (Exception e) {
            throw new ResourceNotFoundException(ENTITY_NAME,e);
        }
    }

    @Override
    public ResponseEntity<?> delete(Long countryId) {
        return countryRepository.findById(countryId).map(country -> {
            countryRepository.delete(country);
            return ResponseEntity.noContent().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, countryId));
    }
}
