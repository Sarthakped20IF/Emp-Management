package com.example.Emp_Man_sys.Controller;

import com.example.Emp_Man_sys.Entity.DeptEntity;
import com.example.Emp_Man_sys.Entity.EmpEntity;
import com.example.Emp_Man_sys.Service.DeptService;
import com.example.Emp_Man_sys.Service.EmpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DeptController {
    private final EmpService empService;
    private final DeptService deptService;
// Injecting Dependencies Manually as this is preferred
    public DeptController(EmpService empService,DeptService deptService){
        this.empService=empService;
        this.deptService=deptService;
    }

    @GetMapping("/get-dept")
    public ResponseEntity<?>getAllDept(){
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

    @PostMapping("/create-dept") public ResponseEntity<?>createDept(@RequestBody DeptEntity deptEntity){
        try {
            DeptEntity dept = deptService.createDept(deptEntity);
            return new ResponseEntity<>(dept,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{dept_Id}")
    public ResponseEntity<?> getDeptById(@PathVariable Long dept_Id){
        DeptEntity dept = deptService.getById(dept_Id);
        try {
            if ( dept!= null){
                return new ResponseEntity<>(dept,HttpStatus.FOUND);
            }else {
                return new ResponseEntity<>("No Department Found with dept_Id: "+dept_Id,HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            return new ResponseEntity<>("Something went Wrong!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
