package com.example.Emp_Man_sys.Repository;

import com.example.Emp_Man_sys.Entity.DeptEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepo extends JpaRepository<DeptEntity,Long> {

}
