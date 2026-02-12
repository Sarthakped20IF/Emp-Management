package com.example.Emp_Man_sys.Entity;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="department")
public class DeptEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dept_id;

    @Column(nullable = false)
    private String deptName;

}
