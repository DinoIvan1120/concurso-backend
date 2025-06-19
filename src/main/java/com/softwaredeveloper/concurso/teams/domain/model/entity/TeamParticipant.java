package com.softwaredeveloper.concurso.teams.domain.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softwaredeveloper.concurso.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "team_participants")
@Entity
public class TeamParticipant extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "participant_id",nullable = false)
    @JsonIgnore
    private Participant participant;

    @ManyToOne(optional = false)
    @JoinColumn(name = "team_id",nullable = false)
    @JsonIgnore
    private Team team;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date registrationDate;

    @Size(max = 1)
    private String active;
}
