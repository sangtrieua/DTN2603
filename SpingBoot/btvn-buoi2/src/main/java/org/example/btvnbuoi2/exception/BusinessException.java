package org.example.btvnbuoi2.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    private String message;
    private int status;


}
