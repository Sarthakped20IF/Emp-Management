package com.example.Emp_Man_sys.Controller;

import com.example.Emp_Man_sys.Entity.DeptEntity;
import com.example.Emp_Man_sys.Service.DeptService;
import com.example.Emp_Man_sys.Service.EmpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Dept_con")
public class DeptController {
    private final EmpService empService;
    private final DeptService deptService;
// Injecting Dependencies Manually as this is preferred
    public DeptController(EmpService empService,DeptService deptService){
        this.empService=empService;
        this.deptService=deptService;
    }

    @GetMapping("/get-dept") public ResponseEntity<?>getAllDept(){
        List<DeptEntity> alldept = deptService.getAlldept();
        try {
            if (!alldept.isEmpty()){
                return new ResponseEntity<>(alldept, HttpStatus.OK);
            }else {
                return new ResponseEntity<>("No Department Found! ",HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
