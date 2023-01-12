package com.cam.generalcrud.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class EmptyInputException extends RuntimeException{
    private String errorCode;
    private String errorMessage;
}
