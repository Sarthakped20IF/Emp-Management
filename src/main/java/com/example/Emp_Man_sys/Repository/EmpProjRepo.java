package com.example.Emp_Man_sys.Repository;

import com.example.Emp_Man_sys.Entity.EmpProjEntity;
import com.example.Emp_Man_sys.Entity.EmpProjId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpProjRepo extends JpaRepository<EmpProjEntity, EmpProjId> {
    List<EmpProjEntity> findByEmp_EmpId(Long emp_id);
}
