package com.example.Emp_Man_sys.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class EmpEntity {
    @Id
    private Long emp_id;
    @Column(nullable = false)
    private String empName;
    @Column(nullable = false)
    private String email;
    private Double salary;

    @ManyToOne (fetch = FetchType.LAZY)// this avoids N+1 problem
    @JoinColumn(name="dept_id")
    private DeptEntity department;
}
