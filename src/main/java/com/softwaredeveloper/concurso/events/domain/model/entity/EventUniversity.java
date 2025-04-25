package com.softwaredeveloper.concurso.events.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softwaredeveloper.concurso.shared.domain.model.AuditModel;
import com.softwaredeveloper.concurso.localizations.domain.model.entity.University;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "event_universities")
@Entity
public class EventUniversity extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id",nullable = false)
    @JsonIgnore
    private Event event;

    @ManyToOne(optional = false)
    @JoinColumn(name = "university_id",nullable = false)
    @JsonIgnore
    private University university;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date registrationDate;

    @NotNull
    @Size(max = 1)
    private String active;
}
