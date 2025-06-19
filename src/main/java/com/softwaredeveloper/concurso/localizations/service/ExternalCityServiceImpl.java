package com.softwaredeveloper.concurso.localizations.service;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.City;
import com.softwaredeveloper.concurso.localizations.domain.model.entity.Country;
import com.softwaredeveloper.concurso.localizations.domain.persistence.CityRepository;
import com.softwaredeveloper.concurso.localizations.domain.persistence.CountryRepository;
import com.softwaredeveloper.concurso.localizations.dto.ExternalCityResource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalCityServiceImpl {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final RestTemplate restTemplate;

    private final String apiUrl = "URL_DE_TU_API_DE_CIUDADES"; // (aquí pondrías la API real de ciudades)

    public ExternalCityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.restTemplate = new RestTemplate();
    }

    public void fetchAndSaveCities() {
        ExternalCityResource[] cities = restTemplate.getForObject(apiUrl, ExternalCityResource[].class);
        if (cities != null) {
            for (ExternalCityResource external : cities) {
                // Buscar el país por el countryCode
                Country country = countryRepository.findByCountryCode(external.getCountryCode());
                if (country != null) {
                    City city = new City();
                    city.setCityName(external.getNombre());
                    city.setCountry(country);
                    cityRepository.save(city);
                }
            }
        }
    }
}
