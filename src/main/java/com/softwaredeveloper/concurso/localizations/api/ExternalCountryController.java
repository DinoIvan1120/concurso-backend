package com.softwaredeveloper.concurso.localizations.api;


import com.softwaredeveloper.concurso.localizations.service.ExternCountryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/external/countries")
public class ExternalCountryController {

    private final ExternCountryServiceImpl externCountryService;

    public ExternalCountryController(ExternCountryServiceImpl externalCountryService) {
        this.externCountryService = externalCountryService;
    }

    @PostMapping("/fetch")
    public ResponseEntity<String> fetchCountries() {
        externCountryService.fetchAndSaveCountries();
        return ResponseEntity.ok("Países importados exitosamente");
    }
}
