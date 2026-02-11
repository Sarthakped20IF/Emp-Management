package com.example.Emp_Man_sys.Entity;

import com.sun.istack.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="department")
public class DeptEntity {

    @Id
    private Long dept_id;

    @Column(nullable = false)
    private String deptName;

}
