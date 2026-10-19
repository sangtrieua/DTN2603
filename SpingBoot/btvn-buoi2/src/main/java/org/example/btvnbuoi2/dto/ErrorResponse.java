package org.example.btvnbuoi2.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ErrorResponse {
    private String message;
    private int status;
    private LocalDate timestamp;
}
