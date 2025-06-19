package com.softwaredeveloper.concurso.localizations.dto.city;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCityResource {

    @NotNull(message = "El nombre de la ciudad es obligatorio")
    @Column(name = "city_name", nullable = false, length = 100)
    private String cityName;

}
