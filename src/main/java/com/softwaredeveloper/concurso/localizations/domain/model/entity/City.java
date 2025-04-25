package com.softwaredeveloper.concurso.localizations.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softwaredeveloper.concurso.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "cities")
@Entity
public class City extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name",nullable = false, length = 100)
    private String cityName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id",nullable = false)
    @JsonIgnore
    private Country country;
}
