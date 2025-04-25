package com.softwaredeveloper.concurso.challenges.domain.model.entity;


import com.softwaredeveloper.concurso.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Table(name = "challenges")
@Entity
public class Challenge extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "challenge_title",nullable = false,length = 100,unique = true)
    private String challengeTitle;
    @Column(name = "challenge_description",nullable = false,length = 2000)
    private String challengeDescription;

    @NotNull
    @Size(max = 1)
    private String active;
}
