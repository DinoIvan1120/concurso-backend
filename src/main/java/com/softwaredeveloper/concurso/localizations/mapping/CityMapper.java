package com.softwaredeveloper.concurso.localizations.mapping;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.City;
import com.softwaredeveloper.concurso.localizations.dto.city.CityResource;
import com.softwaredeveloper.concurso.localizations.dto.city.CreateCityResource;
import com.softwaredeveloper.concurso.localizations.dto.city.UpdateCityResource;
import com.softwaredeveloper.concurso.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class CityMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public CityResource toResource(City city){return mapper.map(city, CityResource.class);}

    public java.util.List<CityResource> toResource(java.util.List<City> model){
        return mapper.mapList(model, CityResource.class);
    }

    public City toModel(CreateCityResource resource){return mapper.map(resource, City.class);}

    public City toModel(UpdateCityResource resource){
        return mapper.map(resource, City.class);
    }

    public Page<CityResource> modelListToPage(List<City> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, CityResource.class), pageable, modelList.size());
    }
}
