package com.softwaredeveloper.concurso.localizations.domain.service;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.City;
import com.softwaredeveloper.concurso.localizations.domain.model.entity.University;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UniversityService {

    List<University> getAllUniversities();
    University getById(Long universityId);
    University getByUsername(String universityName);
    Page<University> getAllUniversitiesPage(Pageable pageable);
    University create(University university, Long cityId);
    University update(University university, Long universityId);
    ResponseEntity<?> delete(Long universityId);

}
