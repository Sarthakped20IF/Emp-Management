//package com.example.Emp_Man_sys.Entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import jakarta.persistence.Entity;
//import lombok.Data;
//
//@Entity
//@Data
//@Table(name = "emp_proj")
//public class EmpProjEntity {
//    @EmbeddedId
//    private EmpProjId id;
//
//    @ManyToOne
//    @MapsId("emp_id")
//    @JoinColumn(name = "emp_id")
//    @JsonIgnore
//    private EmpEntity emp;
//
//
//    @ManyToOne
//    @MapsId("proj_id")
//    @JoinColumn(name = "proj_id")
//    @JsonIgnore
//    private ProjEntity projects;
//
//
//    private String role;
//
//}

//from github

package com.example.Emp_Man_sys.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "emp_proj")
public class EmpProjEntity {
    @EmbeddedId
    private EmpProjId id;

    @ManyToOne
    @MapsId("empId")
    @JoinColumn(name = "emp_id")
    @JsonIgnore
    private EmpEntity emp;


    @ManyToOne
    @MapsId("projId")
    @JoinColumn(name = "proj_id")
    @JsonIgnore
    private ProjEntity projects;

    private LocalDate AssignedDate;

    private String role;

}
