package com.example.Emp_Man_sys.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="employee")
@Data
public class EmpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emp_id;
    @Column(nullable = false)
    private String empName;
//    @Column(nullable = false)
    private String Wemail;
    private Double salary;
    // we dont need @Temporal LocalDate has it inbuild
    private LocalDate Joined_on = LocalDate.now();


    @ManyToOne (fetch = FetchType.LAZY)// this avoids N+1 problem
    @JoinColumn(name="dept_id")
    @JsonIgnore
    private DeptEntity department;



    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private UserEntity userEntity;

//    @ManyToMany
//    @JoinTable(
//            name = "emp_project",
//            joinColumns = @JoinColumn(name = "emp_id"),
//            inverseJoinColumns = @JoinColumn(name = "proj_id")
//    )
    @OneToMany (mappedBy = "emp",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<EmpProjEntity> empProjects;

}
