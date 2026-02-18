package com.example.Emp_Man_sys.DTOS;
//
//import com.example.Emp_Man_sys.Entity.DeptEntity;
//import lombok.Data;
//
//@Data
//public class DeptDtos extends DeptEntity {
//    private Long deptId;
//    private String deptName;
//}

//package com.example.ems.Dtos;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class DeptDtos {
//
//    private Long id;
//    private String deptName;
//    private String code;
//}

//package com.example.ems.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptDtos {

    private Long id;
    private String deptName;
    private String code;
}

