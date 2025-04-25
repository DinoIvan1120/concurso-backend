package com.softwaredeveloper.concurso.localizations.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.With;

@Data
public class CreateCountryResource {

    @Column(name = "country_name", nullable = false, length = 50)
    private String countryName;
}
