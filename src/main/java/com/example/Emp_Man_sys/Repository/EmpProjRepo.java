package com.example.Emp_Man_sys.Repository;

import com.example.Emp_Man_sys.Entity.EmpProjEntity;
import com.example.Emp_Man_sys.Entity.EmpProjId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpProjRepo extends JpaRepository<EmpProjEntity, EmpProjId> {
    
}
