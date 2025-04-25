package com.softwaredeveloper.concurso.localizations.api;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.City;
import com.softwaredeveloper.concurso.localizations.domain.model.entity.Country;
import com.softwaredeveloper.concurso.localizations.domain.service.CityService;
import com.softwaredeveloper.concurso.localizations.domain.service.CountryService;
import com.softwaredeveloper.concurso.localizations.dto.*;
import com.softwaredeveloper.concurso.localizations.mapping.CityMapper;
import com.softwaredeveloper.concurso.localizations.mapping.CountryMapper;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/cities")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CityController {

    private final CityService cityService;

    private final CityMapper mapper;

    public CityController(CityService cityService, CityMapper mapper) {
        this.cityService = cityService;
        this.mapper = mapper;
    }

    @GetMapping("/list")
    public List<CityResource> getAll(){return mapper.toResource(cityService.getAllCities());}


    @GetMapping("/username/{username}")
    public CityResource getCityByUsername(@PathVariable String username){
        return mapper.toResource(cityService.getByUsername(username));
    }

    @GetMapping
    public Page<CityResource> getAllCities(@ParameterObject Pageable pageable) {
        Page<City> cityPage = cityService.getAllCitiesPage(pageable);

        List<CityResource> cityResources = cityPage
                .getContent()
                .stream()
                .map(mapper::toResource)
                .collect(Collectors.toList());

        return new PageImpl<>(cityResources, pageable, cityPage.getTotalElements());
    }

    @GetMapping("/{cityId}")
    public CityResource getCityById(@PathVariable Long cityId){
        return mapper.toResource(cityService.getById(cityId));
    }

    @PostMapping
    public ResponseEntity<CityResource >createCity(@Valid @RequestBody CreateCityResource resource){
        CityResource cityResource = cityService.create(resource);
        return new ResponseEntity<>(cityResource, HttpStatus.CREATED);
    }

    @PutMapping("/{cityId}")
    public CityResource updateCity(@PathVariable Long cityId, @RequestBody UpdateCityResource resource){
        return mapper.toResource(cityService.update(cityId, mapper.toModel(resource)));
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<?> deleteCity(@PathVariable Long cityId){
        return cityService.delete(cityId);
    }
}
