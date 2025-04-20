package com.softwaredeveloper.concurso.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "inscriptions")
@Entity
public class Inscription extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "team_id",nullable = false)
    @JsonIgnore
    private Team team;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id",nullable = false)
    @JsonIgnore
    private Event event;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_team_id",nullable = false)
    @JsonIgnore
    private EventTeam eventTeam;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_university_id",nullable = false)
    @JsonIgnore
    private EventUniversity eventUniversity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "solution_id",nullable = false)
    @JsonIgnore
    private Solution solution;

}
