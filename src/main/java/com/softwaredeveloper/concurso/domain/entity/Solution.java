package com.softwaredeveloper.concurso.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "solutions")
@Entity
public class Solution extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "solution_title", nullable = false,length = 100, unique = true)
    private String solutionTitle;

    @Column(name = "solution_description",nullable = false,length = 100)
    private String solutionDescription;

    @ManyToOne(optional = false)
    @JoinColumn(name = "challege_id",nullable = false)
    @JsonIgnore
    private Challenge challenge;
}
