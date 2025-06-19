package com.softwaredeveloper.concurso.localizations.dto.university;

import com.softwaredeveloper.concurso.localizations.dto.city.CityResource;
import lombok.Data;

@Data
public class UniversityResource {

    private Long id;
    private String UniversityName;
    private CityResource city;
}
