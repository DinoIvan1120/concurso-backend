package com.softwaredeveloper.concurso.localizations.dto.country;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CreateCountryResource {

    @Column(name = "country_name", nullable = false, length = 50)
    private String countryName;

    @Column(name = "country_code", nullable = false, length = 50)
    private String countryCode;
}
