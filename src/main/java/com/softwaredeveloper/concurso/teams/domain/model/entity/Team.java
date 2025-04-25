package com.softwaredeveloper.concurso.teams.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softwaredeveloper.concurso.shared.domain.model.AuditModel;
import com.softwaredeveloper.concurso.localizations.domain.model.entity.University;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "teams")
@Entity
public class Team extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name", nullable = false,length = 50)
    private String teamName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "university_id",nullable = false)
    @JsonIgnore
    private University university;
}
