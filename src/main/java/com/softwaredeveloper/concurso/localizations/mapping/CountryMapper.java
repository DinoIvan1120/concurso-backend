package com.softwaredeveloper.concurso.localizations.mapping;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.Country;
import com.softwaredeveloper.concurso.localizations.dto.CountryResource;
import com.softwaredeveloper.concurso.localizations.dto.CreateCountryResource;
import com.softwaredeveloper.concurso.localizations.dto.UpdateCountryResource;
import com.softwaredeveloper.concurso.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class CountryMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public CountryResource toResource(Country model){
        return mapper.map(model, CountryResource.class);
    }

    public java.util.List<CountryResource> toResource(java.util.List<Country> model){
        return mapper.mapList(model, CountryResource.class);
    }

    public Country toModel(CreateCountryResource resource){
        return mapper.map(resource, Country.class);
    }

    public Country toModel(UpdateCountryResource resource){
        return mapper.map(resource, Country.class);
    }

    public Page<CountryResource> modelListToPage(List<Country> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, CountryResource.class), pageable, modelList.size());
    }

}
