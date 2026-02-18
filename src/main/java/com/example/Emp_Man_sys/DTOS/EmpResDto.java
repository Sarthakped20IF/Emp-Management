package com.example.Emp_Man_sys.DTOS;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//@Data
//@AllArgsConstructor
//public class EmpResDto {
//    private Long empId;
//    private String empName;
//    private Double salary;
//    private DeptDtos department;
//}

//package com.example.ems.Dtos;

//import com.example.ems.Dtos.DeptDtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpResDto {

    private Long id;
    private String empName;
    private String email;
    private DeptDtos department;
}

