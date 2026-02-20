package com.example.Emp_Man_sys.exception;

public class DepartmentNotFound extends RuntimeException{
    public DepartmentNotFound(String msg){
        super(msg);
    }
}
