package com.example.Emp_Man_sys.Service;

import com.example.Emp_Man_sys.Entity.DeptEntity;
import com.example.Emp_Man_sys.Entity.EmpEntity;
import com.example.Emp_Man_sys.Repository.DeptRepo;
import com.example.Emp_Man_sys.Repository.EmpRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpService {
    private final DeptRepo deptRepo;
    private final EmpRepo empRepo;
    public EmpService(DeptRepo deptRepo,EmpRepo empRepo){
        this.deptRepo=deptRepo;
        this.empRepo=empRepo;
    }

    public EmpEntity createEmp(Long dept_id , EmpEntity empEntity){
        DeptEntity dept = deptRepo.findById(dept_id).orElseThrow(()->new RuntimeException("Department Not found !"));

        empEntity.setDepartment(dept);
        String generatedWorkEmail = generateWemail(empEntity.getEmpName());
        empEntity.setWemail(generatedWorkEmail); // set the value of Wemail by calling the generateWemail method
        return empRepo.save(empEntity);
    }
//  this method helps to create work email of employees
    private String generateWemail(String empName) {
        return empName.trim().toLowerCase().replaceAll(" ","")+"@adtech.com";
    }

    public List<EmpEntity> getAllemp(){
        List<EmpEntity> allEmp = empRepo.findAll();
        return allEmp;
    }

    public EmpEntity getByid(Long id){
        return empRepo.findById(id).orElseThrow(()->new RuntimeException("Employee not found!"));
    }

    public List<EmpEntity>findempsalarygreaterthan(Double salary){
//        List<EmpEntity> fesgt = empRepo.findBySalaryGreaterThan(salary).stream()
//                .filter(x -> x.getSalary() > salary)
//                .toList();
//        return fesgt;
            return empRepo.findBySalaryGreaterThan(salary);
    }
//    sorting
    public List<EmpEntity> getAllEmployeesSortedDesc(String field) {
        return empRepo.findAll(Sort.by(Sort.Direction.DESC, field));
    }
//    Pagination
    public Page<EmpEntity> getAllEmployeesWithPagination(Pageable pageable) {
        return empRepo.findAll(pageable);
    }



}
