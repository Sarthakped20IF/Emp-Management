package com.example.Emp_Man_sys.Service;

import com.example.Emp_Man_sys.Entity.EmpEntity;
import com.example.Emp_Man_sys.Entity.ProjEntity;
import com.example.Emp_Man_sys.Repository.ProjRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjService {

    private final ProjRepo projRepo;
//    dependency injection
    public ProjService(ProjRepo projRepo){
        this.projRepo=projRepo;
    }
//
//
//    public ProjEntity createProj(ProjEntity projEntity){
//        ProjEntity project = projRepo.save(projEntity);
//        return project;
//    }
//
//    public List<ProjEntity> getAllproj(){
//        List<ProjEntity> allProj = projRepo.findAll();
//        return allProj;
//    }

//    public
    public ProjEntity getByid(Long id){
        return projRepo.findById(id).orElseThrow(()->new RuntimeException("Project not found!"));
    }
    public ProjEntity add_project(ProjEntity project){
        return projRepo.save(project);
    }

    public List<ProjEntity>getall(){
        return projRepo.findAll();
    }
}