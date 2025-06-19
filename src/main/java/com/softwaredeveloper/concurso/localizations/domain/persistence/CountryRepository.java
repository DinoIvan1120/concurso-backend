package com.softwaredeveloper.concurso.localizations.domain.persistence;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByCountryName(String countryName);
    Country findByCountryCode(String countryCode);

}
