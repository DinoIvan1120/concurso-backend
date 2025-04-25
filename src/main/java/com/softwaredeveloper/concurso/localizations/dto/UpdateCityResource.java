package com.softwaredeveloper.concurso.localizations.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateCityResource {

    @Column(name = "city_name", nullable = false, length = 100)
    private String cityName;

    @NotNull(message = "El id del pais es obligatorio")
    private Long countryId;
}
