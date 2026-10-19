package org.example.btvnbuoi2.exception;

import org.jspecify.annotations.Nullable;
import org.springframework.context.MessageSource;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                            HttpHeaders headers, HttpStatusCode status,
                                                                            WebRequest request) {
        Map<String, List<String>> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.groupingBy(fieldError -> fieldError.getField(),
                        Collectors.mapping(fieldError -> fieldError.getDefaultMessage(), Collectors.toList())));


        return new  ResponseEntity<>(errors, headers,HttpStatus.BAD_REQUEST);
    }
}
