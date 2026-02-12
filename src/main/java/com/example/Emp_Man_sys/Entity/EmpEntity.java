package com.example.Emp_Man_sys.Entity;


import jakarta.persistence.*;
import lombok.Data;

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
    @Column(nullable = false)
    private String email;
    private Double salary;

    @ManyToOne (fetch = FetchType.LAZY)// this avoids N+1 problem
    @JoinColumn(name="dept_id")
    private DeptEntity department;


    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private UserEntity userEntity;

//    @ManyToMany
//    @JoinTable(
//            name = "emp_project",
//            joinColumns = @JoinColumn(name = "emp_id"),
//            inverseJoinColumns = @JoinColumn(name = "proj_id")
//    )
//    private Set<ProjEntity> projects;

}
