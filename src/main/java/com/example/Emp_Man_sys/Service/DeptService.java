package com.example.Emp_Man_sys.Service;

import com.example.Emp_Man_sys.Repository.DeptRepo;
import com.example.Emp_Man_sys.Repository.EmpRepo;
import org.springframework.stereotype.Service;

@Service
public class DeptService {

    private final DeptRepo deptRepo;
    private final EmpRepo empRepo;
    public DeptService(DeptRepo deptRepo,EmpRepo empRepo){
        this.deptRepo=deptRepo;
        this.empRepo=empRepo;
    }

    public 
}
