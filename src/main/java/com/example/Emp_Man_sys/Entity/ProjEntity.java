package com.example.Emp_Man_sys.Entity;

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
//    @ManyToMany(mappedBy = "projects")
//    private Set<EmpEntity> employees;
}
