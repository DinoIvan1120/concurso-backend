package com.softwaredeveloper.concurso.localizations.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;
import org.aspectj.bridge.IMessage;

@Data
public class CreateCityResource {

    @Column(name = "city_name", nullable = false, length = 100)
    private String cityName;

    @NotNull(message = "El id del pais es obligatorio")
    private Long countryId;
}
