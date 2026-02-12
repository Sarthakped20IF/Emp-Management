package com.example.Emp_Man_sys.Service;

import com.example.Emp_Man_sys.Entity.DeptEntity;
import com.example.Emp_Man_sys.Repository.DeptRepo;
import com.example.Emp_Man_sys.Repository.EmpRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    private final DeptRepo deptRepo;
    private final EmpRepo empRepo;
    public DeptService(DeptRepo deptRepo,EmpRepo empRepo){
        this.deptRepo=deptRepo;
        this.empRepo=empRepo;
    }


    public List<DeptEntity> getAlldept(){
        List<DeptEntity> depts = deptRepo.findAll();
        return depts;
    }

    public DeptEntity createDept(DeptEntity deptEntity){
        return deptRepo.save(deptEntity);
    }

    public DeptEntity getById(Long id){
        return deptRepo.getById(id);
    }

}
