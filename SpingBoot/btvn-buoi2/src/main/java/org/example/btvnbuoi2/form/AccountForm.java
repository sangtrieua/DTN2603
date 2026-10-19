package org.example.btvnbuoi2.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.btvnbuoi2.enums.PositionName;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountForm {
    @NotBlank
    @Length(min=6, max=100,message = "userName phải có từ 6 đến 100 kí tự")
    private String userName;


    @NotBlank
    @Length(min=6, max=100,message = "email phải có từ 6 đến 100 kí tự")
    @Email(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Email ko đúng định dạng")
    private String email;

    @NotBlank
    @Length(min=6, max=100,message = "fullName phải có từ 6 đến 100 kí tự")
    private String fullName;

    @NotBlank
    @Length(min=6, max=100,message = "departmentName phải có từ 6 đến 100 kí tự")
    private String departmentName;
    private Integer positionId;


    private String password;


}
