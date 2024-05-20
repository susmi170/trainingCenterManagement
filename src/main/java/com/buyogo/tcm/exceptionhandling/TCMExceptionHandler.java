package com.buyogo.tcm.exceptionhandling;

import com.buyogo.tcm.exception.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * ExpceptionHanlder using Controller advice, it will be used to give proper validation error message during post call
 */
@ControllerAdvice
public class TCMExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionResponse handleValidationExceptions(final MethodArgumentNotValidException methodArgumentNotValidException,
                                                                      final HttpServletRequest httpServletRequest) {
        Map<String, String> errors = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(errors.toString());
        error.callerURL(httpServletRequest.getRequestURI());

        return error;
    }


}
