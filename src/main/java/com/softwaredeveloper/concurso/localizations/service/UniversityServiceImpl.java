package com.softwaredeveloper.concurso.localizations.service;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.City;
import com.softwaredeveloper.concurso.localizations.domain.model.entity.University;
import com.softwaredeveloper.concurso.localizations.domain.persistence.CityRepository;
import com.softwaredeveloper.concurso.localizations.domain.persistence.UniversityRepository;
import com.softwaredeveloper.concurso.localizations.domain.service.UniversityService;
import com.softwaredeveloper.concurso.shared.exception.ResourceNotFoundException;
import com.softwaredeveloper.concurso.shared.exception.ResourceValidationException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UniversityServiceImpl implements UniversityService {
    private static final String ENTITY_NAME = "University";
    private final UniversityRepository universityRepository;
    private final CityRepository cityRepository;
    private final Validator validator;


    public UniversityServiceImpl(UniversityRepository universityRepository, Validator validator, CityRepository cityRepository) {
        this.universityRepository = universityRepository;
        this.validator = validator;
        this.cityRepository = cityRepository;
    }


    @Override
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public University getById(Long universityId) {
        return universityRepository.findById(universityId).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, universityId));
    }

    @Override
    public University getByUsername(String universityName) {
        return universityRepository.findByUniversityName(universityName);
    }

    @Override
    public Page<University> getAllUniversitiesPage(Pageable pageable) {
        return universityRepository.findAll(pageable);
    }

    @Override
    public University create(University university, Long cityId) {

        Set<ConstraintViolation<University>> violations = validator.validate(university);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY_NAME, violations);
        }

        var city = cityRepository.findById(cityId).orElseThrow(() -> new ResourceNotFoundException(ENTITY_NAME, cityId));

        try{

            university.setCity(city);
            return universityRepository.save(university);
        }catch (Exception e) {
            throw new ResourceValidationException(ENTITY_NAME, e);
        }
    }

    @Override
    public University update(University university, Long universityId) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long universityId) {
        return null;
    }
}
