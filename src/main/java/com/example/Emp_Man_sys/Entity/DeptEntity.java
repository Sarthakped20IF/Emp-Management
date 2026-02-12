package com.example.Emp_Man_sys.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="departments")
public class DeptEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dept_id;

    @Column(nullable = false)
    private String deptName;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<EmpEntity> employees;


}
