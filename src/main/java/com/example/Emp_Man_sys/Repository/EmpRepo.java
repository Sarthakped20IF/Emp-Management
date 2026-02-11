package com.example.Emp_Man_sys.Repository;

import com.example.Emp_Man_sys.Entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<EmpEntity,Long> {

}
