package com.example.Emp_Man_sys.Controller;

import com.example.Emp_Man_sys.Entity.ProjEntity;
import com.example.Emp_Man_sys.Repository.ProjRepo;
import com.example.Emp_Man_sys.Service.ProjService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjService projService;

    public ProjectController(ProjService projService) {
        this.projService = projService;
    }

    @PostMapping("/add-project") public ProjEntity addproject(@RequestBody ProjEntity project){
        return projService.add_project(project);
    }
    @GetMapping("/getAllprojects") public List<ProjEntity> getAllProjects(){

        return projService.getall();
    }
}
