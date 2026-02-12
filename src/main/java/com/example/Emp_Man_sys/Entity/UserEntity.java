package com.example.Emp_Man_sys.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    private Long emp_id;
    @Column(nullable = false)
    private String Dob;
    @Column(nullable = false)
    private String PhNo;
    @Column(nullable = false)
    private String pEmail;
    @Column(nullable = false)
    private String address;


    @OneToOne
    @MapsId
    @JoinColumn(name = "emp_id")
    @JsonIgnore
    private EmpEntity employee;
}
