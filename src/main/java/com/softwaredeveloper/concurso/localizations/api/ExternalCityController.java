package com.softwaredeveloper.concurso.localizations.api;

import com.softwaredeveloper.concurso.localizations.service.ExternCountryServiceImpl;
import com.softwaredeveloper.concurso.localizations.service.ExternalCityServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/external/cities")
public class ExternalCityController {

    private final ExternalCityServiceImpl externalCityService;

    public ExternalCityController(ExternalCityServiceImpl externalCityService) {
        this.externalCityService = externalCityService;
    }

    @PostMapping("/fetch")
    public ResponseEntity<String> fetchCountries() {
        externalCityService.fetchAndSaveCities();
        return ResponseEntity.ok("Ciudades importados exitosamente");
    }
}
