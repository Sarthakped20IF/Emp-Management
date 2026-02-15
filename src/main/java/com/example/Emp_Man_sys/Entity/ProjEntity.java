package com.example.Emp_Man_sys.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "projects")
public class ProjEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proj_id;
    @Column(nullable = false)
    private String projName;
    @OneToMany(mappedBy = "projects",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<EmpProjEntity> empProjects;
}
