package com.example.Emp_Man_sys.Repository;

import com.example.Emp_Man_sys.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Long> {
}
