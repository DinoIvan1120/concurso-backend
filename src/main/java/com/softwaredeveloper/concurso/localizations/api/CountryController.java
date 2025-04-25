package com.softwaredeveloper.concurso.localizations.api;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.Country;
import com.softwaredeveloper.concurso.localizations.domain.persistence.CountryRepository;
import com.softwaredeveloper.concurso.localizations.domain.service.CountryService;
import com.softwaredeveloper.concurso.localizations.dto.CountryResource;
import com.softwaredeveloper.concurso.localizations.dto.CreateCountryResource;
import com.softwaredeveloper.concurso.localizations.dto.UpdateCountryResource;
import com.softwaredeveloper.concurso.localizations.mapping.CountryMapper;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/countries")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CountryController {

    private final CountryService countryService;

    private final CountryMapper mapper;

    public CountryController(CountryService countryService, CountryMapper mapper) {
        this.countryService = countryService;
        this.mapper = mapper;
    }

    @GetMapping("/list")
    public List<CountryResource>getAll(){return mapper.toResource(countryService.getAll());}


    @GetMapping("/username/{username}")
    public CountryResource getCountryByUsername(@PathVariable String username){
        return mapper.toResource(countryService.getByUsername(username));
    }

    @GetMapping
    public Page<CountryResource>getAllCotries(@ParameterObject Pageable pageable) {
        Page<Country> countryPage = countryService.getAll(pageable);

        List<CountryResource> countryResources = countryPage
                .getContent()
                .stream()
                .map(mapper::toResource)
                .collect(Collectors.toList());

        return new PageImpl<>(countryResources, pageable, countryPage.getTotalElements());
    }

    @GetMapping("/{countryId}")
    public CountryResource getCountryById(@PathVariable Long countryId){
        return mapper.toResource(countryService.getById(countryId));
    }

    @PostMapping
    public CountryResource createCountry(@RequestBody CreateCountryResource resource){
        return mapper.toResource(countryService.create(mapper.toModel(resource)));
    }

    @PutMapping("/{countryId}")
    public CountryResource updateCountry(@PathVariable Long countryId, @RequestBody UpdateCountryResource resource){
        return mapper.toResource(countryService.update(countryId, mapper.toModel(resource)));
    }

    @DeleteMapping("/{countryId}")
    public ResponseEntity<?> deleteCountry(@PathVariable Long countryId){
        return countryService.delete(countryId);
    }
}
