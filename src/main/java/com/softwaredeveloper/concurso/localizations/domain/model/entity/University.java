package com.softwaredeveloper.concurso.localizations.domain.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softwaredeveloper.concurso.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "universities")
@Entity
public class University extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "university_name",nullable = false, length = 300)
    private String universityName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id",nullable = false)
    @JsonIgnore
    private City city;
}
