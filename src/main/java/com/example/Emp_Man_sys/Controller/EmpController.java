package com.example.Emp_Man_sys.Controller;

//import com.example.Emp_Man_sys.Entity.DeptEntity;

import com.example.Emp_Man_sys.Entity.EmpEntity;
import com.example.Emp_Man_sys.Service.DeptService;
import com.example.Emp_Man_sys.Service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

    public EmpController(EmpService empService,DeptService deptService){
        this.empService=empService;
        this.deptService=deptService;
    }

    @GetMapping("/allEmp")
    public ResponseEntity<?> getAllemp(){
        logger.info("Fetching All Employees!");
        List<EmpEntity> allemp = empService.getAllemp();

            if (!allemp.isEmpty()) {
                return new ResponseEntity<>(allemp, HttpStatus.OK);
            }
            logger.warn("No employees Found");
            return new ResponseEntity<>("No Employees Found!",HttpStatus.NO_CONTENT);
    }

    @PostMapping("/create-emp")
    public ResponseEntity<EmpEntity>createemp(@RequestParam Long dept_id , @RequestBody EmpEntity empEntity){
        logger.info("Creating employee with email {}", empEntity.getWemail());
            EmpEntity emp = empService.createEmp(dept_id, empEntity);
            return new ResponseEntity<EmpEntity>(emp,HttpStatus.CREATED);
    }

    @GetMapping("/{emp_Id}")
    public ResponseEntity<?> getById(@PathVariable Long emp_Id){
        EmpEntity emp = empService.getByid(emp_Id);
        if (emp != null){
            return new ResponseEntity<>(emp,HttpStatus.OK);
        }
        return new ResponseEntity<>("No employee Found with emp_Id: "+emp_Id,HttpStatus.NOT_FOUND);
    }
//    @GetMapping("/fc/{id}")
//    public ResponseEntity<EmpResDto> getEmployee(@PathVariable Long id) {
//
//        return ResponseEntity.ok(
//                empService.getEmployeeWithDepartment(id)
//        );
//    } not worked due to monolithic arhitechture

    @GetMapping("/getempwithsalarygt")
    public ResponseEntity<?>findempsalarygreaterthan(@RequestParam Double salary){
        List<EmpEntity> findempsalarygreaterthan = empService.findempsalarygreaterthan(salary);

            if (!findempsalarygreaterthan.isEmpty()){
                return new ResponseEntity<>(findempsalarygreaterthan,HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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





//package com.example.ems.Controller;
//
//import com.example.Emp_Man_sys.DTOS.EmpResDto;
////import com.example.ems.Dtos.EmpResponseDto;
////import com.example.Emp_Man_sys.Entity.EmpEntity;
////import com.example.ems.Service.EmpService;
//import com.example.Emp_Man_sys.Service.EmpService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/employees")
//@RequiredArgsConstructor
//public class EmpController {
//
//    private final EmpService empService;
//
//    @PostMapping
//    public ResponseEntity<EmpEntity> createEmployee(
//            @RequestBody EmpEntity employee) {
//        return ResponseEntity.ok(empService.saveEmployee(employee));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<EmpResDto> getEmployeeById(
//            @PathVariable Long id) {
//        return ResponseEntity.ok(empService.getEmployeeById(id));
//    }
//}
