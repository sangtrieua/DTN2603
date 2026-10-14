package org.example.btvnbuoi2.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.btvnbuoi2.enums.PositionName;

import java.time.LocalDate;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountForm {
    private String userName;
    private String email;
    private String fullName;
    private String departmentName;
    private Integer positionId;
    private String password;
    public void checkNull(){
        if (this.userName == null || userName.isBlank()){
            throw new RuntimeException("Không để trống username");
        }
        if (this.email == null || email.isBlank()){
            throw new RuntimeException("Không để trống email");
        }
        if (this.fullName == null || fullName.isBlank()){
            throw new RuntimeException("Không để trống fullName");
        }
        if (this.departmentName == null  || departmentName.isBlank()){
            throw new RuntimeException("Không để trống departmentName");
        }
        if (this.positionId == null  ){
            throw new RuntimeException("Không để trống positionId");
        }
        if (this.password == null || this.password.isBlank()){
            throw new RuntimeException("Không để trống password");
        }
    }

}
