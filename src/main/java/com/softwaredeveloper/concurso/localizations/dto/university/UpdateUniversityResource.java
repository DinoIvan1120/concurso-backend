package com.softwaredeveloper.concurso.localizations.dto.university;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateUniversityResource {

    @NotNull(message = "El nombre de la universidad es obligatorio")
    @Column(name = "university_name",nullable = false, length = 300)
    private String universityName;
}
