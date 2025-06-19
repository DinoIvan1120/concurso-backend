package com.softwaredeveloper.concurso.localizations.dto.city;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UpdateCityResource {

    @Column(name = "city_name", nullable = false, length = 100)
    private String cityName;
}
