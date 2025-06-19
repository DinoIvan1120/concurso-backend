package com.softwaredeveloper.concurso.events.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.softwaredeveloper.concurso.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;


@Data
@Table(name = "events")
@Entity
public class Event extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_name",nullable = false,length = 100)
    private String eventName;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @Column(name = "event_date",nullable = false)
    private Date eventDate;

    @Column(name = "event_location",nullable = false,length = 100)
    private String eventLocation;
    @Column(name = "event_url",nullable = false,length = 1000)
    private String eventUrl;

    @NotNull
    @Size(max = 1)
    private Integer state;

    @NotNull
    @Size(max = 1)
    private String active;
}
