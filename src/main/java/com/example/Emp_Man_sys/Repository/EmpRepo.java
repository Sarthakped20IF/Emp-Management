package com.example.Emp_Man_sys.Repository;

import com.example.Emp_Man_sys.Entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpRepo extends JpaRepository<EmpEntity,Long> {
    @Override
    Optional<EmpEntity> findById(Long aLong);
}
