package org.example.btvnbuoi2.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountSearchForm {
    private String userName;
    private String email;
    private String fullName;
    private String depName;
    private String posName;
}
