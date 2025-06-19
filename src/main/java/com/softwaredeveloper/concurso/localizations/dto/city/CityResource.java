package com.softwaredeveloper.concurso.localizations.dto.city;

import com.softwaredeveloper.concurso.localizations.dto.country.CountryResource;
import lombok.Data;

@Data
public class CityResource {

    private Long id;
    private String cityName;
    private CountryResource country;

}
