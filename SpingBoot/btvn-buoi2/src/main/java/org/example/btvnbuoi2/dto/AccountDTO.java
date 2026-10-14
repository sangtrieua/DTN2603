package org.example.btvnbuoi2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private Integer accountId;
    private String email;
    private String userName;
    private String fullName;
    private String departmentName;
    private String positionName;
    private LocalDate createDate;
}
