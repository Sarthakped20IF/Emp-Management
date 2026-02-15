package com.example.Emp_Man_sys.Controller;

import com.example.Emp_Man_sys.Entity.EmpProjEntity;
import com.example.Emp_Man_sys.Service.EmpProjectService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/epm")
public class EmpProjManController {


    private final EmpProjectService empProjectService;

    public EmpProjManController(EmpProjectService empProjectService) {
        this.empProjectService = empProjectService;
    }

    @PostMapping("/assign")
    public EmpProjEntity assign_project(@RequestParam Long emp_id ,
                                        @RequestParam Long proj_id ,
                                        @RequestParam String role){
        return empProjectService.assignProject(emp_id,proj_id,role);
    }
}
