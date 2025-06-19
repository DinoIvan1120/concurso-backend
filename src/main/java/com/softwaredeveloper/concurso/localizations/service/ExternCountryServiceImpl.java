package com.softwaredeveloper.concurso.localizations.service;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.Country;
import com.softwaredeveloper.concurso.localizations.domain.persistence.CountryRepository;
import com.softwaredeveloper.concurso.localizations.dto.ExternalCountryResource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternCountryServiceImpl {

    private final CountryRepository countryRepository;
    private final RestTemplate restTemplate;

    private final String apiUrl = "https://w2u0p21rq7.execute-api.us-east-2.amazonaws.com/ulatinhack/api/pais/findAll/";

    public ExternCountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
        this.restTemplate = new RestTemplate();
    }

    public void fetchAndSaveCountries() {
        ExternalCountryResource[] countries = restTemplate.getForObject(apiUrl, ExternalCountryResource[].class);
        if (countries != null) {
            for (ExternalCountryResource external : countries) {
                Country country = new Country();
                country.setCountryName(external.getNombre());
                country.setCountryCode(external.getCode());
                countryRepository.save(country);
            }
        }
    }
}
