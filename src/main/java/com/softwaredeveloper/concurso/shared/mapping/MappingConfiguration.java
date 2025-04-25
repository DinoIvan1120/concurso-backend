package com.softwaredeveloper.concurso.shared.mapping;

import com.softwaredeveloper.concurso.localizations.mapping.CityMapper;
import com.softwaredeveloper.concurso.localizations.mapping.CountryMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("concursoModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }

    @Bean
    public CountryMapper countryMapper() {return new CountryMapper();}

    @Bean
    public CityMapper cityMapper() {return new CityMapper();}
    
}
