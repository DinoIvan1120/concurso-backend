package com.softwaredeveloper.concurso.localizations.service;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.City;
import com.softwaredeveloper.concurso.localizations.domain.persistence.CityRepository;
import com.softwaredeveloper.concurso.localizations.domain.persistence.CountryRepository;
import com.softwaredeveloper.concurso.localizations.domain.service.CityService;
import com.softwaredeveloper.concurso.shared.exception.ResourceNotFoundException;
import com.softwaredeveloper.concurso.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CityServiceImpl implements CityService {

    private static final String ENTITY_NAME = "City";
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    private static final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);

    private final Validator validator;

    public CityServiceImpl(CityRepository repository, Validator validator, CountryRepository countryRepository) {
        this.cityRepository = repository;
        this.validator = validator;
        this.countryRepository = countryRepository;

    }

    @Override
    public List<City> getAllCities() {return cityRepository.findAll();}

    @Override
    public City getById(Long cityId) {
        return cityRepository.findById(cityId).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, cityId));
    }

    @Override
    public City getByUsername(String cityName) {
        return cityRepository.findByCityName(cityName);
    }

    @Override
    public Page<City> getAllCitiesPage(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public City create(City city, Long countryId) {


        Set<ConstraintViolation<City>> violations = validator.validate(city);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY_NAME, violations);
        }


        var country = countryRepository.findById(countryId).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, countryId));

       try{

           city.setCountry(country);
           return cityRepository.save(city);
       }catch (Exception e) {
           throw new ResourceValidationException(ENTITY_NAME, e);
       }
    }


    @Override
    public City update(City request, Long cityId) {
        Set<ConstraintViolation<City>> violations = validator.validate(request);

        if(!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY_NAME,violations);
        }

        try {
            return cityRepository.findById(cityId)
                    .map(city -> {
                        city.setCityName(request.getCityName());
                        return cityRepository.save(city);
                    })
                    .orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, cityId));

        }catch (Exception e) {
            throw new ResourceNotFoundException(ENTITY_NAME,e);
        }
    }

    @Override
    public ResponseEntity<?> delete(Long cityId) {
        return cityRepository.findById(cityId).map(city -> {
            cityRepository.delete(city);
            return ResponseEntity.noContent().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, cityId));
    }
}
