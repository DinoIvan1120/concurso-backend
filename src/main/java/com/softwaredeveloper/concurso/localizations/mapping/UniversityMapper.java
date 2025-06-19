package com.softwaredeveloper.concurso.localizations.mapping;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.University;
import com.softwaredeveloper.concurso.localizations.dto.university.CreateUniversityResource;
import com.softwaredeveloper.concurso.localizations.dto.university.UniversityResource;
import com.softwaredeveloper.concurso.localizations.dto.university.UpdateUniversityResource;
import com.softwaredeveloper.concurso.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UniversityMapper implements Serializable{

    @Autowired
    private EnhancedModelMapper mapper;

    public UniversityResource toResource(University university){return mapper.map(university, UniversityResource.class);}

    public List<UniversityResource> toResource(List<University> model){return mapper.mapList(model, UniversityResource.class);
    }

    public University toModel(CreateUniversityResource resource){return mapper.map(resource, University.class);}

    public University toModel(UpdateUniversityResource resource){
        return mapper.map(resource, University.class);
    }

    public Page<UniversityResource> modelListToPage(List<University> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, UniversityResource.class), pageable, modelList.size());
    }
}
