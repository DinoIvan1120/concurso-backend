package com.softwaredeveloper.concurso.localizations.domain.persistence;

import com.softwaredeveloper.concurso.localizations.domain.model.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

    University findByUniversityName(String universityName);
}
