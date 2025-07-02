package com.xhuong.legalcheckproject.exception;

import com.xhuong.legalcheckproject.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse> handleResourceNotFound(){
        return ResponseEntity.ok(new ApiResponse(1000, "Resource not found.", null));
    }
}
