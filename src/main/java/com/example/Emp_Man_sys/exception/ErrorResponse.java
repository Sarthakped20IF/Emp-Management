package com.example.Emp_Man_sys.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponse {


    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
