package com.softwaredeveloper.concurso.localizations.domain.model.entity;

import com.softwaredeveloper.concurso.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "countries")
@Entity
public class Country extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_name", nullable = false, length = 50)
    private String countryName;
}
