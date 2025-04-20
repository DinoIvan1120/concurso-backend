package com.softwaredeveloper.concurso.domain.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Table(name = "participants")
@Entity
public class Participant extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "participant_name", nullable = false, length = 50)
    private String participantName;

    @NotNull
    @Size(max = 50)
    private String degree;

    @NotNull
    @Size(max = 50)
    private String email;

    @NotNull
    @Column(name = "coordinator_email",nullable = false, length = 50)
    private String coordinatorEmail;

    @NotNull
    @Column(name = "coordinator_name",nullable = false, length = 50)
    private String coordinatorName;

    @NotNull
    @Column(name = "team_leader")
    private Boolean teamLeader;


    @Size(max = 500)
    @NotNull
    private String linkedin;
}
