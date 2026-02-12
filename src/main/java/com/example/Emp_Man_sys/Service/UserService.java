package com.example.Emp_Man_sys.Service;

import com.example.Emp_Man_sys.Entity.EmpEntity;
import com.example.Emp_Man_sys.Entity.UserEntity;
import com.example.Emp_Man_sys.Repository.EmpRepo;
import com.example.Emp_Man_sys.Repository.UserRepo;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final EmpRepo empRepo;

    public UserService(UserRepo userRepo , EmpRepo empRepo){
        this.userRepo=userRepo;
        this.empRepo=empRepo;
    }

    public UserEntity createUser(Long emp_id , UserEntity userEntity){
        EmpEntity emp = empRepo.findById(emp_id).orElseThrow(()-> new RuntimeException("No Employee Found !"));
        userEntity.setEmployee(emp);
        return userRepo.save(userEntity);
    }

    public Optional<UserEntity>getUserById(Long emp_id){
        return userRepo.findById(emp_id);
    }

    public void deleteById(Long emp_id){
        UserEntity user = userRepo.findById(emp_id).orElseThrow(() -> new RuntimeException("Employee not found"));
        userRepo.delete(user);
    }

    public UserEntity updateUser(Long emp_id , UserEntity updatedEntity){
        UserEntity existingUser = userRepo.findById(emp_id).orElseThrow(()->new RuntimeException("Employee Not Found"));

        existingUser.setDob(updatedEntity.getDob());
        existingUser.setPhNo(updatedEntity.getPhNo());
        existingUser.setPEmail(updatedEntity.getPEmail());
        existingUser.setAddress(updatedEntity.getAddress());
        return userRepo.save(existingUser);
    }
}
