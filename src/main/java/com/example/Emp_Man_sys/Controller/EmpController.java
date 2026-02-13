package com.example.Emp_Man_sys.Controller;

//import com.example.Emp_Man_sys.Entity.DeptEntity;
import com.example.Emp_Man_sys.Entity.EmpEntity;
import com.example.Emp_Man_sys.Service.DeptService;
import com.example.Emp_Man_sys.Service.EmpService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmpController {
    private final EmpService empService;
    private final DeptService deptService;

    public EmpController(EmpService empService,DeptService deptService){
        this.empService=empService;
        this.deptService=deptService;
    }

    @GetMapping("/allEmp")
    public ResponseEntity<?> getAllemp(){
        List<EmpEntity> allemp = empService.getAllemp();
        try {
            if (!allemp.isEmpty()){
                return new ResponseEntity<>(allemp,HttpStatus.OK);
            }else {
                return new ResponseEntity<>("No Employees Found!",HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Something went Wrong!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create-emp")
    public ResponseEntity<EmpEntity>createemp(@RequestParam Long dept_id , @RequestBody EmpEntity empEntity){
        try {
            EmpEntity emp = empService.createEmp(dept_id, empEntity);
            return new ResponseEntity<EmpEntity>(emp,HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<EmpEntity>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{emp_Id}")
    public ResponseEntity<?> getById(@PathVariable Long emp_Id){
        EmpEntity emp = empService.getByid(emp_Id);
        try {
            if (emp != null){
                return new ResponseEntity<>(emp,HttpStatus.OK);
            }else {
                return new ResponseEntity<>("No employee Found with emp_Id: "+emp_Id,HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            return new ResponseEntity<>("Something went Wrong!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getempwithsalarygt")
    public ResponseEntity<?>findempsalarygreaterthan(@RequestParam Double salary){
        List<EmpEntity> findempsalarygreaterthan = empService.findempsalarygreaterthan(salary);
        try {
            if (!findempsalarygreaterthan.isEmpty()){
                return new ResponseEntity<>(findempsalarygreaterthan,HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    pagination
    @GetMapping("/paginated")
    public ResponseEntity<Page<EmpEntity>> getEmployeesWithPagination(Pageable pageable) {
        Page<EmpEntity> employees = empService.getAllEmployeesWithPagination(pageable);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    @GetMapping("/sorted")
    public List<EmpEntity> getEmployeesSorted(
            @RequestParam String field
//            @RequestParam(defaultValue = "asc") String direction
    ) {
        return empService.getAllEmployeesSortedDesc(field);
    }



}
