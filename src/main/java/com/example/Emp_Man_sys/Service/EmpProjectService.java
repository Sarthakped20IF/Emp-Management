package com.example.Emp_Man_sys.Service;

import com.example.Emp_Man_sys.Entity.EmpEntity;
import com.example.Emp_Man_sys.Entity.EmpProjEntity;
import com.example.Emp_Man_sys.Entity.EmpProjId;
import com.example.Emp_Man_sys.Entity.ProjEntity;
import com.example.Emp_Man_sys.Repository.EmpProjRepo;
import com.example.Emp_Man_sys.Repository.EmpRepo;
import com.example.Emp_Man_sys.Repository.ProjRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpProjectService {
    private final EmpProjRepo empProjRepo;
    private final EmpRepo empRepo;
    private final ProjRepo projRepo;

    public EmpProjectService(EmpProjRepo empProjRepo, EmpRepo empRepo, ProjRepo projRepo){
        this.empProjRepo=empProjRepo;
        this.empRepo = empRepo;
        this.projRepo = projRepo;
    }

    public EmpProjEntity assignProject (Long emp_id , Long proj_id , String role){
//        EmpEntity emp = empRepo.findById(emp_id).orElseThrow(()->new RuntimeException("Employee Not Found"));
//        ProjEntity project = projRepo.findById(proj_id).orElseThrow(()->new RuntimeException("Project Not Found"));
//
//        EmpProjId id = new EmpProjId();
//        id.setEmp_id(emp_id);
//        id.setProj_id(proj_id);
//
//        EmpProjEntity empProject = new EmpProjEntity();
//        empProject.setId(id);
//        empProject.setEmp(emp);
//        empProject.setProjects(project);
//        empProject.setRole(role);
//
//        return empProjRepo.save(empProject);
        EmpEntity emp = empRepo.findById(emp_id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));

        ProjEntity project = projRepo.findById(proj_id)
                .orElseThrow(() -> new RuntimeException("Project Not Found"));

        EmpProjId id = new EmpProjId();
        id.setEmp_id(emp_id);
        id.setProj_id(proj_id);

        if (empProjRepo.existsById(id)) {
            throw new RuntimeException("Employee already assigned to this project");
        }

        EmpProjEntity empProject = new EmpProjEntity();
        empProject.setId(id);
        empProject.setEmp(emp);
        empProject.setProjects(project);
        empProject.setRole(role);

        return empProjRepo.save(empProject);
    }
}
