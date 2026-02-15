package com.example.Emp_Man_sys.Repository;

import com.example.Emp_Man_sys.Entity.EmpEntity;
import com.example.Emp_Man_sys.Entity.ProjEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjRepo extends JpaRepository<ProjEntity,Long> {
    @Override
    Optional<ProjEntity> findById(Long id);
}
