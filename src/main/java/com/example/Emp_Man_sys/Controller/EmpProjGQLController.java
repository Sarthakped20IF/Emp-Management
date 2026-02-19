package com.example.Emp_Man_sys.Controller;

import com.example.Emp_Man_sys.Entity.EmpEntity;
import com.example.Emp_Man_sys.Entity.EmpProjEntity;
import com.example.Emp_Man_sys.Entity.EmpProjId;
import com.example.Emp_Man_sys.Entity.ProjEntity;
import com.example.Emp_Man_sys.Repository.EmpProjRepo;
import com.example.Emp_Man_sys.Repository.EmpRepo;
import com.example.Emp_Man_sys.Repository.ProjRepo;
import com.example.Emp_Man_sys.Service.ProjService;
import com.example.model.Employee;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EmpProjGQLController {
    private final ProjRepo repo;
    private final EmpRepo empRepo;
    private final EmpProjRepo empProjRepo;
    private final ProjService projService;

    public EmpProjGQLController(ProjRepo repo, EmpRepo empRepo, EmpProjRepo empProjRepo, ProjService projService) {
        this.repo = repo;
        this.empRepo = empRepo;
        this.empProjRepo = empProjRepo;
        this.projService = projService;
    }

    @MutationMapping
    public ProjEntity createProject(@Argument String projectName) {

        ProjEntity p = new ProjEntity();
        p.setProjName(projectName);

        return projService.add_project(p);
    }

    @MutationMapping
    public EmpProjEntity assignEmployeeToProject(
            @Argument Long employeeId,
            @Argument Long projectId) {

        EmpEntity emp = empRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        ProjEntity proj = repo.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        EmpProjEntity ep = new EmpProjEntity();
        EmpProjId id = new EmpProjId();
        id.setEmpId(emp.getEmpId());
        id.setProjId(proj.getProjId());


        ep.setId(id);
        ep.setEmp(emp);
        ep.setProjects(proj);
        ep.setAssignedDate(LocalDate.now());

        return empProjRepo.save(ep);
    }

    @QueryMapping
    public List<ProjEntity> getProjectsByEmployee(@Argument Long employeeId) {

        return empProjRepo
                .findByEmp_EmpId(employeeId)
                .stream()
                .map(EmpProjEntity::getProjects)
                .toList();
    }



}
