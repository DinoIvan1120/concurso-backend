package com.softwaredeveloper.concurso.localizations.api;

import com.softwaredeveloper.concurso.localizations.domain.service.UniversityService;
import com.softwaredeveloper.concurso.localizations.dto.university.CreateUniversityResource;
import com.softwaredeveloper.concurso.localizations.dto.university.UniversityResource;
import com.softwaredeveloper.concurso.localizations.mapping.UniversityMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/universities")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UniversityController {

    private final UniversityService universityService;

    private final UniversityMapper universityMapper;

    public UniversityController(UniversityService universityService, UniversityMapper universityMapper) {
        this.universityService = universityService;
        this.universityMapper = universityMapper;
    }

    @Operation(summary = "Create University", description = "Create University")
    @PostMapping("/{cityId}")
    public ResponseEntity<UniversityResource> createUniversity(@Valid @RequestBody CreateUniversityResource resource, @PathVariable Long cityId){
        return new ResponseEntity<>(universityMapper.toResource(universityService.create(universityMapper.toModel(resource), cityId)) , HttpStatus.CREATED);
    }

    @Operation(summary = "Get All Universities", description = "Get All Universities")
    @GetMapping("/list")
    public ResponseEntity<List<UniversityResource>> getAllUniversities(){
        return new ResponseEntity<>(universityMapper.toResource(universityService.getAllUniversities()), HttpStatus.OK);
    }
}
